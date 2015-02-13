package cn.com.chinabank.app2.hessian.service.impl;

import cn.com.chinabank.app2.hessian.entity.User;
import cn.com.chinabank.app2.hessian.service.HessianService;
import org.springframework.stereotype.Service;

/**
 * Created by Owner on 2015/2/13.
 */
@Service("hessianService")
public class HessianServiceImpl implements HessianService {
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger
            .getLogger(getClass());
    private String _greeting = "Hello, world";

    private User user;

    public void setGreeting(String greeting) {
        _greeting = greeting;
        logger.info("set greeting success:" + _greeting);
    }

    public String hello() {
        logger.info("baseServer.hello()");
        return _greeting;
    }

    public User getUser() {
        logger.info("baseServer.getUser()");
        if (user != null)
            return user;
        return new User("prance", "meshow");
    }

    public boolean setUser(User user) {
        logger.info("basicService.setUser(user)");
        this.user = user;
        return true;
    }
}
