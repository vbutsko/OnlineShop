package by.expertsoft.butko.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wladek on 28.08.16.
 */
@Controller
@RequestMapping("/order/confirmation")
public class OrderConfirmationController {

    @RequestMapping(method = RequestMethod.GET)
    public String showConfirmationInformation(){
        return "orderConfirmationPage";
    }

}
