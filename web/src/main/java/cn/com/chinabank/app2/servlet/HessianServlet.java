package cn.com.chinabank.app2.servlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Created with IntelliJ IDEA.
 * User: baowp
 * Date: 11/11/13
 * Time: 10:47 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(value = "/servlet/hessian/hello", initParams = {@WebInitParam(name = "service-class", value = "cn.com.chinabank.app2.hessian.service.impl.BasicService")})
public class HessianServlet extends com.caucho.hessian.server.HessianServlet {


}
