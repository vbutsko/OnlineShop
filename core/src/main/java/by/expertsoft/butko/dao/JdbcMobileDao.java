package by.expertsoft.butko.dao;

import by.expertsoft.butko.model.Mobile;
import by.expertsoft.butko.tools.MobileMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wladek on 09.08.16.
 */
public class JdbcMobileDao implements DAO<Mobile> {
    private static String SQL_INSERT_INTO_MOBILES = "INSERT INTO MOBILEPHONES (NAME, COST, PRODUCER_ID) "+
            "VALUES (:name, :cost, :p_id)";
    private static String SQL_INSERT_INTO_PRODUCERS = "INSERT INTO PRODUCERS (PRODUCER_NAME) " +
            "VALUES (:p_name)";
    private static String SQL_SELECT_ALL_RECORDS = "SELECT * FROM MOBILEPHONES INNER JOIN PRODUCERS " +
            "WHERE mobilephones.producer_id = producers.producer_id";
    private static String SQL_SELECT_MOBILE_BY_ID = "SELECT * FROM MOBILEPHONES INNER JOIN PRODUCERS " +
            "WHERE mobile_id =:m_id AND mobilephones.producer_id = producers.producer_id";
    private static String SQL_DELETE_FROM_MOBILEPHONES = "DELETE FROM MOBILEPHONES WHERE mobile_id = :m_id";
    private static String SQL_DELETE_FROM_PRODUCERS = "DELETE FROM PRODUCERS WHERE producer_id = :p_id";
    private static String SQL_SELECT_COUNT_BY_PRODUCER_ID ="SELECT COUNT(*) FROM MOBILEPHONES WHERE producer_id = :p_id";
    private static String SQL_UPDATE_MOBILEPHONES = "UPDATE MOBILEPHONES SET name = :name AND cost = :cost AND producer_id = :p_id "+
            "WHERE mobile_id =:m_id";
    private static String SQL_FIND_PRODUCER_BY_NAME = "SELECT producer_id FROM PRODUCERS WHERE producer_name = :p_name";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void insert(Mobile mobile) {
        Map<String, Object> params = new HashMap<String, Object>();
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        params.put("p_name", mobile.getProducer().getProducer_name());
        int p_id = namedParameterJdbcTemplate.queryForObject(SQL_FIND_PRODUCER_BY_NAME, params, Integer.class);
        if(p_id <= 0){
            namedParameterJdbcTemplate.update(SQL_INSERT_INTO_PRODUCERS, new MapSqlParameterSource(params), holder);
            p_id = holder.getKey().intValue();
        }
        mobile.getProducer().setProducer_id(p_id);
        params.clear();

        params.put("name", mobile.getName());
        params.put("cost", mobile.getCost());
        params.put("p_id", mobile.getProducer().getProducer_id());
        namedParameterJdbcTemplate.update(SQL_INSERT_INTO_MOBILES, new MapSqlParameterSource(params), holder);
        mobile.setId(holder.getKey().intValue());
    }

    public Mobile getById(Integer id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("m_id", id);
        Mobile mobile = (Mobile) namedParameterJdbcTemplate.queryForObject(SQL_SELECT_MOBILE_BY_ID, params, new MobileMapper());
        return mobile;
    }

    public void remove(Mobile mobile) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("m_id", Integer.valueOf(mobile.getId()));
        namedParameterJdbcTemplate.update(SQL_DELETE_FROM_MOBILEPHONES, namedParameters);
        namedParameters = new MapSqlParameterSource("p_id", Integer.valueOf(mobile.getProducer().getProducer_id()));
        int count = namedParameterJdbcTemplate.queryForObject(SQL_SELECT_COUNT_BY_PRODUCER_ID, namedParameters, Integer.class);
        if(count == 0){
            namedParameterJdbcTemplate.update(SQL_DELETE_FROM_PRODUCERS, namedParameters);
        }
    }

    public List<Mobile> getList() {
        List mobiles = (List) namedParameterJdbcTemplate.query(SQL_SELECT_ALL_RECORDS, (RowMapper<Mobile>) new MobileMapper());
        return mobiles;
    }

    public void update(Mobile mobile) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", mobile.getName());
        params.put("cost", mobile.getCost());
        params.put("p_id", mobile.getProducer().getProducer_id());
        namedParameterJdbcTemplate.update(SQL_UPDATE_MOBILEPHONES, params);
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
}
