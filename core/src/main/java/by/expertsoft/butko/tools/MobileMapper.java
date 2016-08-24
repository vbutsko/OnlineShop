package by.expertsoft.butko.tools;

import by.expertsoft.butko.model.Mobile;
import by.expertsoft.butko.model.Producer;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wladek on 11.08.16.
 */
public class MobileMapper implements RowMapper {
    public Mobile mapRow(ResultSet rs, int rowNum) throws SQLException {
        Producer producer = new Producer();
        producer.setProducer_id(rs.getInt("producer_id"));
        producer.setProducer_name(rs.getString("producer_name"));
        Mobile mobile = new Mobile();
        mobile.setProducer(producer);
        mobile.setCost(rs.getDouble("cost"));
        mobile.setId(rs.getInt("mobile_id"));
        mobile.setName(rs.getString("name"));
        return mobile;
    }
}
