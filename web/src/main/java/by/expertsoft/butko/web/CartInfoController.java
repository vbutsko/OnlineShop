package by.expertsoft.butko.web;

import by.expertsoft.butko.dao.DAO;
import by.expertsoft.butko.model.Cart;
import by.expertsoft.butko.model.CartItem;
import by.expertsoft.butko.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * Created by wladek on 16.08.16.
 */
@Controller
@RequestMapping("/cart")
public class CartInfoController {

    @Autowired
    private CartService cartService;

    @RequestMapping(method = RequestMethod.GET)
    public String getCartList(Map<String, Object> model, HttpServletRequest request){
        Cart cartSession = cartService.getCart(request); //(Cart) request.getSession().getAttribute("cart");
        Cart cart = new Cart();
        for(int i = 0; i < cartSession.getCartSize(); i++){
            cart.addCartItem(new CartItem());
        }
        model.put("cart", cart);
        return "cartPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String addProductsToCart(@Valid @ModelAttribute(value="cartItem")CartItem cartItem, BindingResult resultOrderInfo,
                                                  HttpServletRequest request){
        String returnText;
        if(!resultOrderInfo.hasErrors()){
            cartService.addCartItem(request,cartItem);
            returnText = cartItem.getName() + " x" + cartItem.getAmount() +" now in your Cart.";
        }else{
            returnText = "Sorry, an error has occur. Products have not been added to cart.";
        }
        return returnText;
    }

    @RequestMapping(params = "delete", method = RequestMethod.POST)
    public String delete(@RequestParam(required = true) Integer cartItemId, HttpServletRequest request){
        cartService.deleteCartItem(request, cartItemId);
        return "redirect:/cart";
    }

    @RequestMapping(params = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute("cart")Cart cart,
                         HttpServletRequest request, BindingResult result){
        Cart cartSession = cartService.getCart(request);
        for(int i = cart.getCartSize()-1; i >=0; i--){
            if(cart.getCartItemById(i).getAmount() == 0) {
                cartSession.deleteCartItem(i);
            }else{
                cartSession.getCartItemById(i).setAmount(cart.getCartItemById(i).getAmount());
            }
        }
        cartService.setCart(request, cartSession);
        return "cartPage";
    }
}
