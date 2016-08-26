package by.expertsoft.butko.web;

import by.expertsoft.butko.phone.Cart;
import by.expertsoft.butko.phone.CartItem;
import by.expertsoft.butko.phone.JsonResponse;
import by.expertsoft.butko.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
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
    public @ResponseBody JsonResponse addProductsToCart(@Valid @ModelAttribute(value="cartItem")CartItem cartItem, BindingResult resultCartItem,
                                   HttpServletRequest request){
        JsonResponse jsonResponse = new JsonResponse();
        if(!resultCartItem.hasErrors()){
            cartService.addCartItem(request,cartItem);
            jsonResponse.setStatus("SUCCESS");
            jsonResponse.setResult(cartItem.getName() + " x" + cartItem.getAmount() +" now in your Cart.");
        }else{
            jsonResponse.setStatus("FAIL");
            jsonResponse.setResult("amount must be integer greater or equals than 1");
        }
        jsonResponse.setStatusBar(cartService.getCart(request).getTotalAmount() + " :Amount; "
                                + cartService.getCart(request).getTotal() + ": Total");
        return jsonResponse;
    }

    @RequestMapping(params = "delete", method = RequestMethod.POST)
    public String delete(@RequestParam(required = true) Integer cartItemId, HttpServletRequest request){
        cartService.deleteCartItem(request, cartItemId);
        return "redirect:/cart";
    }

    @RequestMapping(params = "update", method = RequestMethod.POST)
    public String update(@Valid@ModelAttribute("cart")Cart cart, BindingResult resultCart,
                         HttpServletRequest request){
        if(resultCart.hasErrors()) {
            return "cartPage";
        }else{
            Cart cartSession = cartService.getCart(request);
            for (int i = cart.getCartSize() - 1; i >= 0; i--) {
                cartSession.getCartItemById(i).setAmount(cart.getCartItemById(i).getAmount());
            }
            cartService.setCart(request, cartSession);
            return "redirect:/cart";
        }
    }
}
