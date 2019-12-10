package com.dfbz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/10 10:36
 */
@Component(value = "dog")
public class Dog {

    @Value("${dogname}")
    String name;
    @Value("${dogage}")
    Integer age;


    public void say() {
        System.out.println("大家好，我是狗！");
        System.out.println(name + '-' + age);
    }


}
