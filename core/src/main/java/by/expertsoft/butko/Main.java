package by.expertsoft.butko;

import by.expertsoft.butko.cart.Order;
import by.expertsoft.butko.cart.OrderItem;
import by.expertsoft.butko.cart.PersonalInfo;
import by.expertsoft.butko.dao.GenericDao;
import by.expertsoft.butko.dao.order.JdbcOrderDao;
import by.expertsoft.butko.dao.order.OrderDao;
import by.expertsoft.butko.phone.Phone;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wladek on 09.08.16.
 */
public class Main {
    public static void main(String[] args){
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GenericDao mobileDao = (GenericDao) context.getBean("jdbcPhoneDao");
        /*Phone phone1 = new Phone(4, "iphone SE", new BigDecimal(40), new Manufacturer(4, "Apple"));
        mobileDao.insert(phone1);
        mobileDao.remove(phone1);
        List<Phone> mobiles = mobileDao.getList();
        for(Phone mob: mobiles) {
            System.out.println(mob.getId() + " "+mob.getName());
        }
        System.out.println(phone1.getId());
        context.close();*/
        PersonalInfo personalInfo = new PersonalInfo(); personalInfo.setFirstName("wladek2"); personalInfo.setLastName("butko2"); personalInfo.setPhoneNumber("+375445861985");
        List<OrderItem> list = new ArrayList<>();
        OrderItem orderItem = new OrderItem(((Phone)mobileDao.getById(3)).getPrice());
        orderItem.setProductId(3); orderItem.setAmount(1);
        list.add(orderItem);
        orderItem = new OrderItem(((Phone)mobileDao.getById(2)).getPrice()); orderItem.setProductId(2); orderItem.setAmount(2);
        list.add(orderItem);
        Order order = new Order(new BigDecimal(165));
        order.setPersonalInfo(personalInfo);
        order.setCartItemList(list);

        JdbcOrderDao orderDao = (JdbcOrderDao) context.getBean("jdbcOrderDao");
        //orderDao.insert(order);

        //orderDao.update(order);

        /*List<Order> listOrder = orderDao.getList();
        for(Order order1: listOrder){
            List<OrderItem> orderItemList = order1.getCartItemList();
            for(OrderItem orderItem1: orderItemList){
                System.out.print(orderItem1.getProductId() + "  ,  ");
            }
            System.out.println();
        }*/
        System.out.println(orderDao.getById("1421147712520916"));
    }
}
