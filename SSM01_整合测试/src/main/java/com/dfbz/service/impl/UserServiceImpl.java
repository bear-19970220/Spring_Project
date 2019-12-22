package com.dfbz.service.impl;

import com.dfbz.domain.User;
import com.dfbz.mapper.UserMapper666;
import com.dfbz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/20 13:01
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper666 userMapper666;

//    @Bean
//    public  UserMapper666 createUserMapper(){
//        try {
//            return new SqlSessionFactoryBuilder()
//                    .build(Resources.getResourceAsReader("MyBatis.cfg.xml"))
//                    .openSession()
//                    .getMapper(UserMapper666.class);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    public UserServiceImpl(){
//        try {
//            userMapper666 = new SqlSessionFactoryBuilder()
//                    .build(Resources.getResourceAsReader("MyBatis.cfg.xml"))
//                    .openSession()
//                    .getMapper(UserMapper666.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public List<User> listUser(){
        return userMapper666.findAllUser();
//        return createUserMapper().findAllUser();

    }
}
