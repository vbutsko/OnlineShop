package by.expertsoft.butko.service;

import by.expertsoft.butko.cart.AbstractCart;
import by.expertsoft.butko.cart.AbstractCartItem;
import by.expertsoft.butko.dao.phone.PhoneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wladek on 12.09.16.
 */
@Service
public class OrderInformationService {
    @Autowired
    private PhoneDao jdbcPhoneDao;

    public <T extends AbstractCartItem> List getCartItemNamesList(AbstractCart<T> abstractCart){
        List result = new ArrayList(abstractCart.getCartSize());
        for(AbstractCartItem cartItem: abstractCart.getCartItemList()){
            result.add(getCartItemName(cartItem.getProductId()));
        }
        return result;
    }
    public String getCartItemName(int productId){
        return jdbcPhoneDao.getById(productId).getName();
    }

    public <T extends AbstractCartItem> BigDecimal getDeliveryPrice(AbstractCart<T> abstractCart){
        Integer price = 5 * abstractCart.getCartSize();
        return new BigDecimal(price);
    }
}
