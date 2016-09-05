package by.expertsoft.butko.dao.phone;

import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/**
 * Created by wladek on 05.09.16.
 */
public class JdbcOrderDao implements OrderDao {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void insert(Order order){}
    public Order getById(Integer id){
        return null;
    }
    public void remove(Order order){

    }
    public List<Order> getList(){
        return null;
    }
    public void update(Order order){

    }
}
