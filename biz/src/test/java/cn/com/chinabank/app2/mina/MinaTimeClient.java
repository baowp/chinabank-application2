package cn.com.chinabank.app2.mina;

import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.example.sumup.ClientSessionHandler;
import org.apache.mina.example.sumup.codec.SumUpProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * User: baowp
 * Date: 11/11/13
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class MinaTimeClient {

    private static final boolean USE_CUSTOM_CODEC=true;
    public static void main(String[] args) throws Throwable {
        NioSocketConnector connector = new NioSocketConnector();
        connector.setConnectTimeoutMillis(10*1000);

       /* if (USE_CUSTOM_CODEC) {
            connector.getFilterChain().addLast("codec",
                    new ProtocolCodecFilter(new SumUpProtocolCodecFactory(false)));
        } else {
            connector.getFilterChain().addLast("codec",
                    new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
        }*/
        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));


        connector.getFilterChain().addLast("logger", new LoggingFilter());
        connector.setHandler(new ClientSessionHandler(new int[]{1}));
        IoSession session;

        for (;;) {
            try {
                ConnectFuture future = connector.connect(new InetSocketAddress("localhost", MinaTimeServer.PORT));
                future.awaitUninterruptibly();
                session = future.getSession();
                //session.write(3);
                break;
            } catch (RuntimeIoException e) {
                System.err.println("Failed to connect.");
                e.printStackTrace();
                Thread.sleep(5000);
            }
        }

        // wait until the summation is done
        session.getCloseFuture().awaitUninterruptibly();
        connector.dispose();
    }
}
