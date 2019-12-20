package com.dfbz.com.dfbz.controller;

import com.dfbz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/20 14:46
 */
@Controller("userController")
public class UserController {

    @Autowired
    private UserService userService;

    public void listUser(){
        userService.listUser().forEach(u-> System.out.println(u));
    }

}
