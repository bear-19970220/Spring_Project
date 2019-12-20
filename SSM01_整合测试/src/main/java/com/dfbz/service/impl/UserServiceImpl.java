package com.dfbz.service.impl;

import com.dfbz.domain.User;
import com.dfbz.mapper.UserMapper;
import com.dfbz.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/20 13:01
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public UserServiceImpl(){
        try {
            userMapper = new SqlSessionFactoryBuilder()
                    .build(Resources.getResourceAsReader("mybatis.cfg.xml"))
                    .openSession()
                    .getMapper(UserMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<User> listUser() {
        return userMapper.findAllUser();

    }
}
