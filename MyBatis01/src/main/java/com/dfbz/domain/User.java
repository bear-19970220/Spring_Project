package com.dfbz.domain;

import java.io.Serializable;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/12 17:54
 */
public class User implements Serializable {

    private Integer uid; // uId
    private String uname; //uName

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public User() {
    }

    public User(Integer uid, String uname) {
        this.uid = uid;
        this.uname = uname;
    }
}