package by.expertsoft.butko.web;

import by.expertsoft.butko.phone.Cart;
import by.expertsoft.butko.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wladek on 03.09.16.
 */
@Controller
@RequestMapping(value = "/total/update")
public class TotalBarController {

    @Autowired
    private CartService cartService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    String getTotalBar(){
        Cart cart = cartService.getCart();
        return cart.getTotalAmount() + " :Amount; "
                + cart.getTotalCost() + ": Total";
    }
}
