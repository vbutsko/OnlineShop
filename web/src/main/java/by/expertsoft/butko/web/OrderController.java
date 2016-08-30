package by.expertsoft.butko.web;


import by.expertsoft.butko.phone.PersonalInfo;
import by.expertsoft.butko.service.CartService;
import by.expertsoft.butko.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by wladek on 26.08.16.
 */
@Controller
@RequestMapping("/order")
// rename to OrderController
public class OrderController {
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public String getCartList(Map<String, Object> model, HttpServletRequest request){
        PersonalInfo personalInfo = (PersonalInfo) orderService.getPersonalInfo(request);
        model.put("personalInfo", personalInfo);
        model.put("cartSession", cartService.getCart(request));
        List cartItemNames = cartService.getCartItemNamesList(cartService.getCart(request));
        model.put("cartItemNames", cartItemNames);
        return "orderInformationPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String placeOrder(@Valid @ModelAttribute("personalInfo")PersonalInfo personalInfo,
                                   BindingResult resultPersonalInfo, HttpServletRequest request){
        if(resultPersonalInfo.hasErrors()) {
            return "orderInformationPage";
        }else{
            orderService.setPersonalInfo(personalInfo, request);
            return "redirect:/order/confirmation";
        }
    }
}
