package cn.com.chinabank.app2.mina.handler;

/**
 * Created with IntelliJ IDEA.
 * User: baowp
 * Date: 11/11/13
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.example.sumup.message.ResultMessage;

import java.util.Date;

public class TimeServerHandler extends IoHandlerAdapter {
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String str = message.toString();
        if (str.trim().equalsIgnoreCase("quit")) {
            session.close();
            return;
        }
        Date date = new Date();
        ResultMessage rm=new ResultMessage();
        session.write(rm);
        System.out.println("Message written...");
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        // longlived connection
        System.out.println("message sent success...");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        System.out.println("IDLE " + session.getIdleCount(status));
    }
}
