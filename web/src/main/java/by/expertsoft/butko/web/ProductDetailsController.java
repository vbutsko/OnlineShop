package by.expertsoft.butko.web;

import by.expertsoft.butko.dao.GenericDao;
import by.expertsoft.butko.phone.Phone;
import by.expertsoft.butko.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by wladek on 16.08.16.
 */
@Controller
@RequestMapping("/mobilephones/model")
public class ProductDetailsController {
    @Autowired
    private GenericDao jdbcPhoneDao;
    @Autowired
    private CartService cartService;

    @RequestMapping(method = RequestMethod.GET)
    public String getMobilephone(
            @RequestParam(required = true) int id,
            Map<String, Object> model,
            HttpServletRequest request
    ){
        Phone phone = (Phone)jdbcPhoneDao.getById(id);
        model.put("productDetails", phone);
        model.put("cart", cartService.getCart());
        return "productDetails";
    }
}
