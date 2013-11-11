package cn.com.chinabank.app2.hessian.service.impl;

import cn.com.chinabank.app2.hessian.entity.User;
import cn.com.chinabank.app2.hessian.service.BasicAPI;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: baowp
 * Date: 11/11/13
 * Time: 9:55 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class BasicService implements BasicAPI {
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger
            .getLogger(getClass());
    private String _greeting = "Hello, world";

    public void setGreeting(String greeting) {
        _greeting = greeting;
        System.out.println("set greeting success:" + _greeting);
    }

    public String hello() {
        logger.info("baseServer.hello()");
        return _greeting;
    }

    public User getUser() {
        logger.info("baseServer.getUser()");
        return new User("prance", "meshow");
    }
}
