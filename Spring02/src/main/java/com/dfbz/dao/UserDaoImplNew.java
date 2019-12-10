package com.dfbz.dao;

import org.springframework.stereotype.Repository;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/10 17:07
 */
@Repository
public class UserDaoImplNew implements UserDao {

    @Override
    public void daoHaha() {
        System.out.println("哈哈哈哈，我是新的~@！");
    }
}
