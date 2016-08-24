package by.expertsoft.butko.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wladek on 16.08.16.
 */
@Controller
public class HomePageController {
    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String showHomePage(){
        return "homePage";
    }
}
