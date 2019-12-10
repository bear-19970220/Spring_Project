package controller;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/9 11:31
 */
public class DemoController {

    private String[] strs;
    private List<String> sList;

    public List<String> getsList() {
        return sList;
    }

    public void setsList(List<String> sList) {
        this.sList = sList;
    }

    public String[] getStrs() {
        return strs;
    }

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public void sayHi() {
        System.out.println("哦哈哟！过你急哇");
    }

    public void sayBye() {
        System.out.println("米娜桑，撒有拉拉");
    }


}
