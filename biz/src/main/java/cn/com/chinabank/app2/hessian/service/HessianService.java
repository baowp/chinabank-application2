package cn.com.chinabank.app2.hessian.service;

import cn.com.chinabank.app2.hessian.entity.User;

/**
 * Created by Owner on 2015/2/13.
 */
public interface HessianService {

    public void setGreeting(String greeting);

    public String hello();

    public User getUser();

    public boolean setUser(User user);
}
