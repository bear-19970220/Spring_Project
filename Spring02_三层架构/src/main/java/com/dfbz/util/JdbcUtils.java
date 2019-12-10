package com.dfbz.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/10 18:39
 */
@Component
public class JdbcUtils {

    @Autowired
    private DataSource ds;


    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean
//    @Scope("prototype")
    public DataSource createDataSource() throws Exception {
        Properties props = new Properties();
        props.load(JdbcUtils.class.getResourceAsStream("/db.properties"));
        return DruidDataSourceFactory.createDataSource(props);
    }


    @Bean
    public Connection getConnection(DataSource ds) {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
