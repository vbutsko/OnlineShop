package by.expertsoft.butko.service;

import by.expertsoft.butko.cart.Cart;
import by.expertsoft.butko.cart.Order;
import by.expertsoft.butko.cart.OrderItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by wladek on 16.09.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderInformationServiceTest{
    @Mock
    private OrderItem orderItem1, orderItem2, orderItem3;
    @InjectMocks
    private OrderInformationService orderInformationService = new OrderInformationService();

    @Test
    public void getOrder() throws Exception {
        Order order = new Order();
        order.getCartItemList().add(orderItem1);
        assertEquals(new BigDecimal(5), orderInformationService.getDeliveryPrice(order));
        order.getCartItemList().add(orderItem2);
        assertEquals(new BigDecimal(10), orderInformationService.getDeliveryPrice(order));
        order.getCartItemList().add(orderItem3);
        assertEquals(new BigDecimal(15), orderInformationService.getDeliveryPrice(order));
    }
}