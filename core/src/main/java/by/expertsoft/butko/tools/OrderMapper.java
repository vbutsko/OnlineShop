package by.expertsoft.butko.tools;

import by.expertsoft.butko.cart.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wladek on 05.09.16.
 */
public class OrderMapper implements RowMapper {
    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();

        return order;
    }
}
