package com.dfbz.domain;

import java.io.Serializable;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/10 18:32
 */
public class User implements Serializable {

    private String uname;
    private String sex;

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User() {
    }

    public User(String uname, String sex) {
        this.uname = uname;
        this.sex = sex;
    }
}