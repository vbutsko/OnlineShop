package by.expertsoft.butko.tools;

import by.expertsoft.butko.phone.Phone;
import by.expertsoft.butko.phone.Manufacturer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wladek on 11.08.16.
 */
public class PhoneMapper implements RowMapper {
    public Phone mapRow(ResultSet rs, int rowNum) throws SQLException {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(rs.getInt("producer_id"));
        manufacturer.setName(rs.getString("producer_name"));
        Phone phone = new Phone();
        phone.setManufacturer(manufacturer);
        phone.setPrice(rs.getBigDecimal("cost"));
        phone.setId(rs.getInt("mobile_id"));
        phone.setName(rs.getString("name"));
        return phone;
    }
}
