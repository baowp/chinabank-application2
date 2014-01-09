package cn.com.chinabank.app2.dubbo.spi;

import cn.com.chinabank.app2.dubbo.api.Calculator;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Protocol;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: baowp
 * Date: 1/9/14
 * Time: 1:37 PM
 */
public class CalculatorTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testCalculate() {
        ExtensionLoader<Calculator> extensionLoader = ExtensionLoader.getExtensionLoader(Calculator.class);
        extensions(extensionLoader);

        Calculator calculator;
        /*calculator = extensionLoader.getDefaultExtension(); //find the extension by @SPI value
        calculator.calculate("");*/

        calculator = extensionLoader.getAdaptiveExtension();  //find the extension annotated by @Adaptive,if didn't find it will compile dynamic
        calculator.calculate("");

        calculator = extensionLoader.getExtension("second");
        calculator.calculate("");

        extensions(extensionLoader);
    }

    private void extensions(ExtensionLoader<Calculator> extensionLoader) {
        for (String name : extensionLoader.getLoadedExtensions()) {
            logger.info("LoadedExtension:{}", name); //name override is $key=implement > @Extension($key) [@Deprecated] > $keyInterface
        }
    }

    @Test
    public void testProtocolExtension() {
        ExtensionLoader<Protocol> extensionLoader = ExtensionLoader.getExtensionLoader(Protocol.class);
        Protocol protocol = extensionLoader.getAdaptiveExtension();
        logger.info(protocol.toString());
    }
}
