package by.expertsoft.butko.tools;

import by.expertsoft.butko.cart.Order;
import by.expertsoft.butko.cart.OrderItem;
import by.expertsoft.butko.cart.PersonalInfo;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;


import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wladek on 05.09.16.
 */
public class OrderSetExtractor implements ResultSetExtractor {
    @Override
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Map<String, Order> map = new HashMap<String, Order>();
        Order order = null;
        while (resultSet.next()) {
            String orderId = resultSet.getString("order_id");
            order = map.get(orderId);
            if(order == null){
                boolean deliveredStatus = resultSet.getBoolean("delivered_status");
                BigDecimal deliveryPrice = resultSet.getBigDecimal("delivery_price");
                BigDecimal totalCost = resultSet.getBigDecimal("total_cost");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String phoneNumber = resultSet.getString("phone_number");
                order = new Order();
                order.setOrderId(orderId);
                order.setDeliveredStatus(deliveredStatus);
                order.setDeliveryPrice(deliveryPrice);
                order.setTotalCost(totalCost);
                PersonalInfo personalInfo = order.getPersonalInfo();
                personalInfo.setFirstName(firstName);
                personalInfo.setLastName(lastName);
                personalInfo.setPhoneNumber(phoneNumber);
                //order.setPersonalInfo(personalInfo);

                map.put(orderId, order);
            }
            OrderItem orderItem = new OrderItem(resultSet.getBigDecimal("price_for_one"));
            orderItem.setAmount(resultSet.getInt("amount"));
            orderItem.setProductId(resultSet.getInt("product_id"));
            order.getCartItemList().add(orderItem);
        }
        return new ArrayList<Order>(map.values());
    }
}
