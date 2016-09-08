package by.expertsoft.butko.dao.order;

import by.expertsoft.butko.cart.Order;
import by.expertsoft.butko.cart.OrderItem;
import by.expertsoft.butko.tools.OrderSetExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wladek on 05.09.16.
 */
public class JdbcOrderDao implements OrderDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String SQL_INSERT_INTO_ORDERS = "INSERT INTO ORDERS (order_id, delivered_status, delivery_price, total_cost,  first_name, last_name, phone_number) " +
            "VALUES (:order_id, :delivered_status, :delivery_price, :total_cost, :first_name, :last_name, :phone_number)";
    private static final String SQL_INSERT_INTO_ORDER_ITEMS = "INSERT INTO ORDER_ITEMS (order_id, product_id, amount, price_for_one) " +
            "VALUES (:order_id, :product_id, :amount, :price_for_one)";
    private static final String SQL_SELECT_ALL_RECORDS = "SELECT * FROM ORDERS JOIN ORDER_ITEMS ON orders.order_id = order_items.order_id";
    private static final String SQL_SELECT_BY_ORDER_ID = "SELECT * FROM ORDERS JOIN ORDER_ITEMS ON orders.order_id = order_items.order_id WHERE ORDERS.order_id = :order_id ";
    private static final String SQL_UPDATE_ORDERS = "UPDATE ORDERS SET delivered_status = :delivered_status "+
            "WHERE order_id = :order_id";

    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("HHmmssSDDMMYY");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
    @Override
    public void insert(Order order) {
        Map<String, Object> params = new HashMap<String, Object>();
        String orderId = getCurrentTimeStamp();
        order.setOrderId(orderId);
        System.out.println(orderId);
        params.put("order_id", orderId);
        params.put("delivered_status", order.getDeliveredStatus());
        params.put("delivery_price", order.getDeliveryPrice());
        params.put("total_cost", order.getTotalCost());
        params.put("first_name", order.getPersonalInfo().getFirstName());
        params.put("last_name", order.getPersonalInfo().getLastName());
        params.put("phone_number", order.getPersonalInfo().getPhoneNumber());
        namedParameterJdbcTemplate.update(SQL_INSERT_INTO_ORDERS, new MapSqlParameterSource(params));
        // TODO: play with transactions, isolation level
        for(OrderItem orderItem: order.getCartItemList()){
            params.put("product_id", orderItem.getProductId());
            params.put("amount", orderItem.getAmount());
            params.put("price_for_one", orderItem.getPriceForOne());
            namedParameterJdbcTemplate.update(SQL_INSERT_INTO_ORDER_ITEMS, new MapSqlParameterSource(params));
        }
    }

    @Override
    public Order getById(Integer id) {
        throw new RuntimeException("The operation is not supported");
    }
    public Order getById(String orderId){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("order_id", orderId);
        List<Order> orderList = (List) namedParameterJdbcTemplate.query(SQL_SELECT_BY_ORDER_ID, params, new OrderSetExtractor());
        return orderList.get(0);
    }
    @Override
    public void remove(Order order) {
        throw new RuntimeException("The operation is not supported");
        // TODO: throw new RuntimeException("The operation is not supported")?
    }

    @Override
    public List<Order> getList() {
        List<Order> orderList = (List)namedParameterJdbcTemplate.query(SQL_SELECT_ALL_RECORDS, new OrderSetExtractor());
        return orderList;
    }

    @Override
    public void update(Order order) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("delivered_status", true);
        params.put("order_id", order.getOrderId());
        namedParameterJdbcTemplate.update(SQL_UPDATE_ORDERS, params);
    }
}
