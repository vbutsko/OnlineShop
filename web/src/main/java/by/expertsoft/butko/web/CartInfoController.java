package by.expertsoft.butko.web;

import by.expertsoft.butko.model.Cart;
import by.expertsoft.butko.model.CartItem;
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

    @RequestMapping(method = RequestMethod.GET)
    public String getCartList(Map<String, Object> model, HttpServletRequest request){
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if(cart == null)
            cart = new Cart();
        Cart orderList = new Cart();
        for(int i = 0; i < cart.getOrdersSize(); i++){
            orderList.addOrder(new CartItem());
        }
        model.put("orderList", orderList);
        return "cartPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String addProductsToCart(@Valid @ModelAttribute(value="orderInfo")CartItem cartItem, BindingResult resultOrderInfo,
                                                  HttpServletRequest request){
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if(cart == null)
            cart = new Cart();
        String returnText;
        if(!resultOrderInfo.hasErrors()){
            cart.addOrder(cartItem);
            request.getSession().setAttribute("cart", cart);
            returnText = cartItem.getName() + " x" + cartItem.getAmount() +" now in your Cart.";
        }else{
            returnText = "Sorry, an error has occur. Products have not been added to cart.";
        }
        return returnText;
    }

    @RequestMapping(params = "delete", method = RequestMethod.POST)
    public String delete(@RequestParam(required = true) Integer orderId, HttpServletRequest request){
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.deleteOrder(orderId);
        request.getSession().setAttribute("cart", cart);
        return "redirect:/cart";
    }

    @RequestMapping(params = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute("orderList")Cart orderList,
                         HttpServletRequest request, BindingResult result){
        Cart cart =(Cart)request.getSession().getAttribute("cart");
        for(int i = orderList.getOrdersSize()-1; i >=0; i--){
            if(orderList.getOrderById(i).getAmount() == 0) {
                cart.deleteOrder(i);
            }else{
                cart.getOrderById(i).setAmount(orderList.getOrderById(i).getAmount());
            }
        }
        request.getSession().setAttribute("cart", cart);
        return "cartPage";
    }
}
