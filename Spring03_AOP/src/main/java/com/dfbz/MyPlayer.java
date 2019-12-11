package com.dfbz;

import org.springframework.stereotype.Component;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/11 18:25
 */
@Component
public class MyPlayer implements Player {

    @Override
    public void play() {
        System.out.println("攻击");
    }

    @Override
    public void eat() {
        try {
            int i = 1 / 0;
            System.out.println("吃吃吃，就知道吃！");
        } catch (Exception e) {
            System.out.println("错了");
        }

    }

    @Override
    public void sleep() {
        System.out.println("中午啦！还睡！猪吗你！");
    }
}
