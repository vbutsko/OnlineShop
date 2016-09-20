package by.expertsoft.butko.service;

import by.expertsoft.butko.cart.CartItem;
import by.expertsoft.butko.cart.Order;
import by.expertsoft.butko.cart.PersonalInfo;
import by.expertsoft.butko.dao.phone.JdbcPhoneDao;
import by.expertsoft.butko.phone.Manufacturer;
import by.expertsoft.butko.phone.Phone;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by wladek on 16.09.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testApplicationContext.xml")
public class TestServices {

    @Autowired
    private JdbcPhoneDao jdbcPhoneDao;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @Test
    public void testAllCycle(){

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("microsoft");

        Phone phone = new Phone();
        phone.setName("lumia 640XL");
        phone.setPrice(new BigDecimal(100));
        phone.setManufacturer(manufacturer);

        jdbcPhoneDao.insert(phone);

        cartService.addCartItem(phone.getId(), 2);

        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setFirstName("mikhail");
        personalInfo.setLastName("metelskij");
        personalInfo.setPhoneNumber("64824");

        String orderId = orderService.placeOrder(personalInfo);

        Order order = orderService.getOrder(orderId);

        assertEquals(orderId, order.getOrderId());
        assertEquals(cartService.getCart().getTotalCost(), order.getTotalCost());

        orderService.confirmOrder(orderId);

        order = orderService.getOrder(orderId);

        assertTrue(order.getDeliveredStatus());

        jdbcPhoneDao.remove(phone);

    }

}
