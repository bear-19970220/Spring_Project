package com.dfbz.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;


/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/12 19:25
 */
public class MyBatisUtils {

    private static SqlSessionFactory factory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.cfg.xml");
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            factory = factoryBuilder.build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession createSqlSession() {
        return factory.openSession();
    }


}
