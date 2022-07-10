package com.example.microservice.DAO;

import com.example.microservice.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RequestDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RequestDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Request> showAll() {
        return jdbcTemplate.query("SELECT * FROM requests", BeanPropertyRowMapper.newInstance(Request.class));
    }
    public void saveRequest(Request request)  {
    	jdbcTemplate.update("CREATE TABLE IF NOT EXISTS requests (id SERIAL NOT NULL PRIMARY KEY, time_sent VARCHAR(50) NOT NULL, address VARCHAR(50) NOT NULL, transactions BIGINT);");
        jdbcTemplate.update("INSERT INTO requests(time_sent, address, transactions) VALUES(?, ?, ?)", request.getTime_sent(),
                request.getAddress(), request.getTransactions());
    }


}
