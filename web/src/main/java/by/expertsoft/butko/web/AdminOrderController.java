package by.expertsoft.butko.web;

import by.expertsoft.butko.cart.Order;
import by.expertsoft.butko.phone.Phone;
import by.expertsoft.butko.service.OrderInformationService;
import by.expertsoft.butko.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by wladek on 15.09.16.
 */
@Controller
@RequestMapping(value = "/admin/orderlist/order")
public class AdminOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderInformationService orderInformationService;

    @RequestMapping(method = RequestMethod.GET)
    public String getOrder(
            @RequestParam(required = true) String order_id,
            Map<String, Object> model
    ){
        Order order = orderService.getOrder(order_id);
        model.put("order", order);
        model.put("orderItemNames", orderInformationService.getCartItemNamesList(order));
        return "orderAdmin";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String confirmOrder(@RequestParam String orderId){
        orderService.confirmOrder(orderId);
        return "redirect:order?order_id="+orderId;
    }
}
