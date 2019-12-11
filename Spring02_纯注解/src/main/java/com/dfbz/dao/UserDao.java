package com.dfbz.dao;

import com.dfbz.domain.User;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/10 18:34
 */
public interface UserDao {

    List<User> findAllUser();

}
