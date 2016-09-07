package by.expertsoft.butko.web;

import by.expertsoft.butko.dao.GenericDao;
import by.expertsoft.butko.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by wladek on 12.08.16.
 */
@Controller
@RequestMapping("/mobilephones")
public class ProductListController {
    @Autowired
    private GenericDao jdbcPhoneDao;
    @Autowired
    private CartService cartService;

    @RequestMapping(method = RequestMethod.GET)
    public String showMobilephonesList(Map<String, Object> model){
        List productList = jdbcPhoneDao.getList();
        model.put("productList", productList);
        model.put("cartSession", cartService.getCart());
        return "productList";
    }
}
