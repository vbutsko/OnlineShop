package by.expertsoft.butko.web;

import by.expertsoft.butko.cart.Order;
import by.expertsoft.butko.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by wladek on 15.09.16.
 */
@Controller
@RequestMapping(value = "/admin/orderlist")
public class AdminOrdersListController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public String getOrderList(Map<String, Object> model){
        model.put("orders", orderService.getOrderList());
        return "orderListAdmin";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String confirmOrder(@RequestParam String orderId){
        orderService.confirmOrder(orderId);
        return "redirect:orderlist";
    }
}
