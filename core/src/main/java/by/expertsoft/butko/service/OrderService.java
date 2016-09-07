package by.expertsoft.butko.service;

import by.expertsoft.butko.cart.Cart;
import by.expertsoft.butko.cart.Order;
import by.expertsoft.butko.cart.PersonalInfo;
import org.springframework.stereotype.Service;

/**
 * Created by wladek on 28.08.16.
 */
@Service
public class OrderService {

    public void placeOrder(Cart cart, PersonalInfo personalInfo){

    }
    public Order getOrder(){
        return new Order();
    }

    // TODO: implement Order placeOrder(Cart cart)
    // TODO: getOrder()

}
