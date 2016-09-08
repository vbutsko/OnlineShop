package by.expertsoft.butko.web;


import by.expertsoft.butko.cart.PersonalInfo;
import by.expertsoft.butko.service.CartService;
import by.expertsoft.butko.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by wladek on 26.08.16.
 * session Attribute
 */
@Controller
@RequestMapping("/order")
@SessionAttributes("personalInfo")
public class OrderController {
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;

    @ModelAttribute
    public PersonalInfo populatePersonalInfo(){
        return new PersonalInfo();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getCartList(Map<String, Object> model){
        model.put("cartSession", cartService.getCart());
        List cartItemNames = cartService.getCartItemNamesList(cartService.getCart());
        model.put("cartItemNames", cartItemNames);
        return "orderInformationPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String placeOrder(
            @Valid @ModelAttribute("personalInfo")PersonalInfo personalInfo,
            BindingResult resultPersonalInfo
    ){
        if(resultPersonalInfo.hasErrors()) {
            return "orderInformationPage";
        }else{
            try {
                String orderId = orderService.placeOrder(cartService.getCart(), personalInfo);
                cartService.clearCart();
                return "redirect:/order/confirmation/"+orderId;
            }
            catch(RuntimeException ex){
                return "redirect:home";
            }
            // put thank you message into flash attributes
        }
    }
}
