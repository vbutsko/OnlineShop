package by.expertsoft.butko.web;

import by.expertsoft.butko.cart.Cart;
import by.expertsoft.butko.forms.CartForm;
import by.expertsoft.butko.forms.CartItemForm;
import by.expertsoft.butko.service.CartService;
import by.expertsoft.butko.service.OrderInformationService;
import by.expertsoft.butko.tools.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wladek on 16.08.16.
 */
@Controller
@RequestMapping("/cart")
@SessionAttributes("cartForm")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private OrderInformationService orderInformationService;
    @ModelAttribute
    public CartForm populateCartForm(){
        CartForm cartForm = new CartForm();
        List<CartItemForm> list = new ArrayList<CartItemForm>();
        Cart cartSession = cartService.getCart();
        for(int i = 0; i < cartSession.getCartSize(); i++){
            CartItemForm cartItemForm = new CartItemForm();
            cartItemForm.setProductId(cartSession.getCartItemList().get(i).getProductId());
            list.add(cartItemForm);
        }
        cartForm.setCartItemFormList(list);
        return cartForm;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String getCartList(
            Map<String, Object> model
    ){
        Cart cart = cartService.getCart();
        model.put("cart", cart);
        List cartItemNames = orderInformationService.getCartItemNamesList(cart);
        model.put("cartItemNames", cartItemNames);
        return "cartPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse addProductsToCart(
            @Valid @ModelAttribute(value="cartItemForm")CartItemForm cartItemForm,
            BindingResult resultCartItem
    ){
        JsonResponse jsonResponse = new JsonResponse();
        Cart cart = cartService.getCart();
        if(!resultCartItem.hasErrors()){
            cartService.addCartItem(cartItemForm.getProductId(), Integer.parseInt(cartItemForm.getAmount()));
            jsonResponse.setStatus("SUCCESS");
            jsonResponse.setResult(orderInformationService.getCartItemName(cartItemForm.getProductId()) +
                                    " x" + cartItemForm.getAmount() +" now in your Cart.");
        }else{
            jsonResponse.setStatus("FAIL");
            jsonResponse.setResult("amount must be integer greater than 0");
        }
        jsonResponse.setStatusBar(cart.getTotalAmount() + " :Amount; "
                                + cart.getTotalCost() + ": Total");
        return jsonResponse;
        // return new HttpResult(message, HttpResult.HttStatus_BAD_REQUEST)
    }

    @RequestMapping(params = "delete", method = RequestMethod.POST)
    public String delete(
            @RequestParam(required = true) Integer cartItemProductId
    ){
        cartService.deleteCartItem(cartItemProductId);
        return "redirect:/cart";
    }

    @RequestMapping(params = "update", method = RequestMethod.POST)
    public String update(
            @Valid@ModelAttribute("cartForm")CartForm cartForm,
            BindingResult resultCart,
            Map<String, Object> model
    ){
        if(resultCart.hasErrors()) {
            Cart cart = cartService.getCart();
            List cartItemNames = orderInformationService.getCartItemNamesList(cart);
            model.put("cartItemNames", cartItemNames);
            model.put("cart", cart);
            return "cartPage";
        }else{
            Map<Integer, Integer> cartMap = new HashMap<Integer, Integer>();
            for(CartItemForm cartItemForm: cartForm.getCartItemFormList()){
                cartMap.put(cartItemForm.getProductId(), Integer.parseInt(cartItemForm.getAmount()));
            }
            cartService.updateCartItem(cartMap);
            return "redirect:/cart";
        }
    }


}
