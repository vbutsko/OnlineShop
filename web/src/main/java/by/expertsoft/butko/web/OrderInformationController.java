package by.expertsoft.butko.web;


import by.expertsoft.butko.phone.Cart;
import by.expertsoft.butko.phone.CartItem;
import by.expertsoft.butko.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by wladek on 26.08.16.
 */
@Controller
@RequestMapping("/order")
public class OrderInformationController {
    @Autowired
    private CartService cartService;

    @RequestMapping(method = RequestMethod.GET)
    public String getCartList(Map<String, Object> model, HttpServletRequest request){
        return "orderInformationPage";
    }

    /*@RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse addProductsToCart(@Valid @ModelAttribute(value="cartItem")CartItem cartItem, BindingResult resultCartItem,
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
    } */
}
