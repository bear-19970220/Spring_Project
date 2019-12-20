package com.dfbz.mapper;

import com.dfbz.domain.User;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/20 9:01
 */
public interface UserMapper {

    List<User> findAllUser();

}
