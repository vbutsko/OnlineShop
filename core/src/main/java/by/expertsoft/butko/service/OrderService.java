package by.expertsoft.butko.service;

import by.expertsoft.butko.cart.*;
import by.expertsoft.butko.dao.order.JdbcOrderDao;
import by.expertsoft.butko.dao.phone.JdbcPhoneDao;
import by.expertsoft.butko.phone.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by wladek on 28.08.16.
 */
@Service
public class OrderService {

    @Autowired
    private JdbcOrderDao jdbcOrderDao;
    @Autowired
    private JdbcPhoneDao jdbcPhoneDao;

    public String placeOrder(Cart cart, PersonalInfo personalInfo, BigDecimal deliveryPrice){
        if(cart.getCartSize() == 0){
            throw new RuntimeException("cart is empty");
        }
        Order order = new Order(cart.getTotalCost());
        order.setPersonalInfo(personalInfo);
        List<OrderItem> orderItemList = new ArrayList<>();
        for(CartItem cartItem: cart.getCartItemList()){
            OrderItem orderItem = new OrderItem(getProductPrice(cartItem.getProductId()));
            orderItem.setAmount(cartItem.getAmount());
            orderItem.setProductId(cartItem.getProductId());
            orderItemList.add(orderItem);
        }
        order.setCartItemList(orderItemList);
        order.setDeliveryPrice(deliveryPrice);
        jdbcOrderDao.insert(order);
        return order.getOrderId();
    }
    public Order getOrder(String orderId){
        return jdbcOrderDao.getById(orderId);
    }

    //maybe better add another SQL request to JdbcPhoneDao to get phone's price???
    private BigDecimal getProductPrice(int productId){
        Phone phone = jdbcPhoneDao.getById(productId);
        return phone.getPrice();
    }

    // TODO: implement Order placeOrder(Cart cart)
    // TODO: getOrder()
    public List<Order> getOrderList(){
        List<Order> orderList = jdbcOrderDao.getList();
        Collections.sort(orderList, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return Boolean.valueOf(o1.getDeliveredStatus()).compareTo(Boolean.valueOf(o2.getDeliveredStatus()));
            }
        });
        return orderList;
    }

    public void confirmOrder(String orderId){
        Order order = new Order();
        order.setOrderId(orderId);
        jdbcOrderDao.update(order);
    }
}
