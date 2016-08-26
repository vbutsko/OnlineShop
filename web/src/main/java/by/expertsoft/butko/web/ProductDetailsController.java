package by.expertsoft.butko.web;

import by.expertsoft.butko.dao.GenericDao;
import by.expertsoft.butko.phone.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by wladek on 16.08.16.
 */
@Controller
@RequestMapping("/mobilephones/model")
public class ProductDetailsController {
    @Autowired
    private GenericDao daoService;

    @RequestMapping(method = RequestMethod.GET)
    public String getMobilephone(@RequestParam int id, Map<String, Object> model){
        Phone phone = (Phone)daoService.getById(id);
        model.put("productDetails", phone);
        return "productDetails";
    }
}
