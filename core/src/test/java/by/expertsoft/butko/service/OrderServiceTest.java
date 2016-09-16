package by.expertsoft.butko.service;

import by.expertsoft.butko.cart.Cart;
import by.expertsoft.butko.cart.CartItem;
import by.expertsoft.butko.cart.Order;
import by.expertsoft.butko.cart.PersonalInfo;
import by.expertsoft.butko.dao.order.JdbcOrderDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by wladek on 12.09.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
    @Mock
    private Order order;
    @Mock
    private Cart cart;
    @Mock
    private PersonalInfo personalInfo;
    @Mock
    private JdbcOrderDao jdbcOrderDao;
    @Mock
    private CartService cartService;
    @Mock
    private OrderInformationService orderInformationService;
    @InjectMocks
    private OrderService orderService = new OrderService();

    @Captor
    private ArgumentCaptor<Order> argCaptor;

    @Test
    public void testPlaceOrder(){
        when(cartService.getCart()).thenReturn(cart);
        when(cart.getTotalCost()).thenReturn(new BigDecimal(100));
        when(cart.getCartItemList()).thenReturn(new ArrayList<CartItem>(3));
        when(orderInformationService.getDeliveryPrice(cart)).thenReturn(new BigDecimal(5));
        String orderId = orderService.placeOrder(personalInfo);
        Mockito.verify(jdbcOrderDao).insert(argCaptor.capture());


        assertEquals(cart.getTotalCost(), argCaptor.getValue().getTotalCost());
    }

    @Test
    public void testGetOrder() throws Exception {
        String order_id = "asd";

        when(jdbcOrderDao.getById(order_id)).thenReturn(order);

        assertEquals(order, orderService.getOrder(order_id));
        assertEquals(order, orderService.getOrder("asd"));
    }
}