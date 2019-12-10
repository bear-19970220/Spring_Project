package com.dfbz.dao;

import org.springframework.stereotype.Repository;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/10 13:06
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void daoHaha(){
        System.out.println("dao...");
    }



}
