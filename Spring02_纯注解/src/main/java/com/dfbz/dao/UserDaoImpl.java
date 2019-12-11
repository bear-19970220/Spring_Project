package com.dfbz.dao;

import com.dfbz.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/10 18:34
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAllUser() {
        return jdbcTemplate.query("select * from t_user", new BeanPropertyRowMapper<>(User.class));
    }
}
