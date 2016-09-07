package by.expertsoft.butko.web;

import by.expertsoft.butko.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by wladek on 16.08.16.
 */
@Controller
public class HomePageController {
    @Autowired
    private CartService cartService;

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String showHomePage(HttpServletRequest request, Map<String, Object> model){
        return "homePage";
    }
}
