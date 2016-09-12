package by.expertsoft.butko.web;

import by.expertsoft.butko.cart.Order;
import by.expertsoft.butko.service.CartService;
import by.expertsoft.butko.service.OrderInformationService;
import by.expertsoft.butko.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
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
    @Autowired
    private OrderInformationService orderInformationService;

    // map .../confirmation/<orderid>
    @RequestMapping(value = "/{orderId}",  method = RequestMethod.GET)
    public String showConfirmationInformation(@PathVariable String orderId, Map<String, Object> model){
        Order order = orderService.getOrder(orderId);
        model.put("order",order);
        List cartItemNames = orderInformationService.getCartItemNamesList(order);
        model.put("cartItemNames", cartItemNames);
        return "orderConfirmationPage";
    }

}
