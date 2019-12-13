package com.dfbz.domain;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/13 9:26
 */
public class Dept {
    private Integer did;
    private String dname;

    public Dept(Integer did, String dname) {
        this.did = did;
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
