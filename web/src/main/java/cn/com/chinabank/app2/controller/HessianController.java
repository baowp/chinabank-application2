package cn.com.chinabank.app2.controller;

import cn.com.chinabank.app2.hessian.entity.User;
import cn.com.chinabank.app2.hessian.service.BasicAPI;
import com.caucho.hessian.client.HessianProxyFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: baowp
 * Date: 11/11/13
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("hessian")
public class HessianController {

    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger
            .getLogger(getClass());

    @Resource
    private HttpServletRequest request;
    @Resource
    private BasicAPI hessianService;

    @ResponseBody
    @RequestMapping(value = "/execute")
    public Object execute() {
        HessianProxyFactory factory = new HessianProxyFactory();
        String url = ("http://" +request.getServerName() + ":" +request.getServerPort() +
                request.getContextPath() + "/hessian/hello");
        BasicAPI basic = null;
        try {
            basic = (BasicAPI) factory.create(BasicAPI.class,url);
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        List<Object> list=new ArrayList<Object>();
        basic.setGreeting("Jim");
        list.add("Hello: " + basic.hello());
        logger.info("hessian.hello invoked");
        list.add("Hello: " + basic.getUser().getUserName());
        basic.setUser(new User("Jack","123"));
        list.add("Hello: " + basic.getUser().getUserName());
        logger.info("hessian.getUser invoked");
        list.add("Hello: " + basic.getUser().getPassword());
        return list;
    }
}
