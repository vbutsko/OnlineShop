package by.expertsoft.butko.dao.order;

import by.expertsoft.butko.cart.AbstractCartItem;
import by.expertsoft.butko.cart.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wladek on 05.09.16.
 */
public class JdbcOrderDao implements OrderDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String SQL_INSERT_INTO_ORDERS = "INSERT INTO ORDERS (order_id, product_id, amount, first_name, last_name, number, delivered_status, delivery_price) " +
            "VALUES (:order_id, :product_id, :amount, :first_name, :last_name, :number, :delivered_status, :delivery_price)";
    private static final String SQL_SELECT_ALL_RECORDS = "SELECT * FROM ORDERS";
    private static final String SQL_UPDATE_ORDERS = "UPDATE ORDERS SET deliveres_status = :delivered_status "+
            "WHERE id = :id";


    @Override
    public void insert(Order order) {
        Map<String, Object> params = new HashMap<String, Object>();
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        params.put("delivery_price", order.getDeliveryCost());
        params.put("order_id", order.getOrderId());
        params.put("first_name", order.getPersonalInfo().getFirstName());
        params.put("last_name", order.getPersonalInfo().getLastName());
        params.put("number", order.getPersonalInfo().getNumber());
        // TODO: play with transactions, isolation level
        for(AbstractCartItem orderItem: order.getCartItemList()){
            params.put("product_id", orderItem.getProductId());
            params.put("amount", orderItem.getAmount());
            namedParameterJdbcTemplate.update(SQL_INSERT_INTO_ORDERS, new MapSqlParameterSource(params));
        }

    }

    @Override
    public Order getById(Integer id) {
        return null;
    }

    @Override
    public void remove(Order order) {
        // TODO: throw new RuntimeException("The operation is not supported")?

    }

    @Override
    public List<Order> getList() {
        return null;
    }

    @Override
    public void update(Order order) {

    }
}
