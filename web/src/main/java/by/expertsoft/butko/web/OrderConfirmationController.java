package by.expertsoft.butko.web;

import by.expertsoft.butko.service.CartService;
import by.expertsoft.butko.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by wladek on 28.08.16.
 */
@Controller
@RequestMapping("/order/confirmation")
public class OrderConfirmationController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @RequestMapping(method = RequestMethod.GET)
    public String showConfirmationInformation(Map<String, Object> model, HttpServletRequest request){
        model.put("cartSession", cartService.getCart(request));
        return "orderConfirmationPage";
    }

}