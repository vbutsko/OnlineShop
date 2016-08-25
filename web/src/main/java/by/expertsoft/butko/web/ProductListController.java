package by.expertsoft.butko.web;

import by.expertsoft.butko.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
@Scope("session")
public class ProductListController {
    @Autowired
    private DAO daoService;

    @RequestMapping(method = RequestMethod.GET)
    public String showMobilephonesList(Map<String, Object> model){
        List productList = daoService.getList();
        model.put("productList", productList);
        return "productList";
    }
}
