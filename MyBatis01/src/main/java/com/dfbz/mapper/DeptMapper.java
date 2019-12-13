package com.dfbz.mapper;

import com.dfbz.domain.Dept;
import com.dfbz.domain.User;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/13 9:26
 */
public interface DeptMapper {

    List<User> findAllUser();

    void addUser(User user);

}
