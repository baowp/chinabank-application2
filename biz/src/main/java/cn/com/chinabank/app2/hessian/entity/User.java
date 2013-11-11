package cn.com.chinabank.app2.hessian.entity;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: baowp
 * Date: 11/11/13
 * Time: 9:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class User implements Serializable {
    String userName = "snoopy";
    String password = "showme";

    public User(String user, String pwd) {
        this.userName = user;
        this.password = pwd;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
