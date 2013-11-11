package cn.com.chinabank.app2.hessian.service;

import cn.com.chinabank.app2.hessian.entity.User;

/**
 * Created with IntelliJ IDEA.
 * User: baowp
 * Date: 11/11/13
 * Time: 9:54 AM
 * To change this template use File | Settings | File Templates.
 */
public interface BasicAPI {
    public void setGreeting(String greeting);

    public String hello();

    public User getUser();
}
