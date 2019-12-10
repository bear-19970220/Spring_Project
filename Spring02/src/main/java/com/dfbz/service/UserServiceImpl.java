package com.dfbz.service;

import com.dfbz.dao.UserDao;
import com.dfbz.dao.UserDaoImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/10 16:43
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Resource(name="userDaoImplNew")
    UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void callDao() {
        userDao.daoHaha();
    }

}
