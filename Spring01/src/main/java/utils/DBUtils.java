package utils;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/9 15:56
 */
public class DBUtils {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void showMsg() {
        System.out.println(username + '-' + password);
    }

}
