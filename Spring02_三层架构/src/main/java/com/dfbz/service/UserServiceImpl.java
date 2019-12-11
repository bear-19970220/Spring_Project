package com.dfbz.service;

import com.dfbz.dao.UserDao;
import com.dfbz.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/11 9:25
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listUser() {
        return userDao.findAllUser();
    }
}
