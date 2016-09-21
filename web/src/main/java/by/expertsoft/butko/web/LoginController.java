package by.expertsoft.butko.web;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by wladek on 21.09.16.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout, Map<String, Object> model) {

        if (error != null) {
            model.put("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.put("msg", "You've been logged out successfully.");
        }

        return "login";

    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accesssDenied(Map<String, Object> model) {

        //check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.put("username", userDetail.getUsername());
        }

        return "403";

    }
}
