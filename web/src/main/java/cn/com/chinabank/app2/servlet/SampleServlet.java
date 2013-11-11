package cn.com.chinabank.app2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: baowp
 * Date: 11/11/13
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(value = "/servlet/sample", loadOnStartup = 1)
public class SampleServlet extends HttpServlet {

    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger
            .getLogger(getClass());
    public void init() {
        logger.info("SampleServlet initialize");
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("sample servlet do get");
    }

    public void destroy() {
        logger.info("SampleServlet destroyed");
    }
}
