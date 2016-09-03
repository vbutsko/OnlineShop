package by.expertsoft.butko.web;

import by.expertsoft.butko.phone.Cart;
import by.expertsoft.butko.phone.CartItem;
import by.expertsoft.butko.phone.JsonResponse;
import by.expertsoft.butko.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
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
    public String getCartList(
            Map<String, Object> model,
            HttpServletRequest request
    ){
        Cart cartSession = cartService.getCart(request);
        model.put("cartSession", cartSession);
        Cart cart = new Cart();
        for(int i = 0; i < cartSession.getCartSize(); i++){
            cart.addCartItem(cartSession.getCartItemList().get(i).getProductId(), 0);
        }
        model.put("cart", cart);
        List cartItemNames = cartService.getCartItemNamesList(cartSession);
        model.put("cartItemNames", cartItemNames);
        return "cartPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody JsonResponse addProductsToCart(
            @Valid @ModelAttribute(value="cartItem")CartItem cartItem,
            BindingResult resultCartItem,
            HttpServletRequest request){
        JsonResponse jsonResponse = new JsonResponse();
        Cart cart = cartService.getCart(request);
        if(!resultCartItem.hasErrors()){
            cartService.addCartItem(request, cartItem.getProductId(), cartItem.getAmount());
            jsonResponse.setStatus("SUCCESS");
            jsonResponse.setResult(cartService.getCartItemName(cartItem.getProductId()) +
                                    " x" + cartItem.getAmount() +" now in your Cart.");
        }else{
            jsonResponse.setStatus("FAIL");
            jsonResponse.setResult("amount must be integer greater or equals than 1");
        }
        jsonResponse.setStatusBar(cart.getTotalAmount() + " :Amount; "
                                + cart.getTotalCost() + ": Total");
        return jsonResponse;
        // return new HttpResult(message, HttpResult.HttStatus_BAD_REQUEST)
    }

    @RequestMapping(params = "delete", method = RequestMethod.POST)
    public String delete(
            @RequestParam(required = true) Integer cartItemProductId,
            HttpServletRequest request
    ){
        cartService.deleteCartItem(request, cartItemProductId);
        return "redirect:/cart";
    }

    @RequestMapping(params = "update", method = RequestMethod.POST)
    public String update(
            @Valid@ModelAttribute("cart")Cart cart,
            BindingResult resultCart,
            HttpServletRequest request
    ){
        if(resultCart.hasErrors()) {
            return "cartPage";
        }else{
            Map<Integer, Integer> cartMap = new HashMap<Integer, Integer>();
            for(CartItem cartItem: cart.getCartItemList()){
                cartMap.put(cartItem.getProductId(), cartItem.getAmount());
            }
            cartService.updateCartItem(request, cartMap);
            return "redirect:/cart";
        }
    }


}
