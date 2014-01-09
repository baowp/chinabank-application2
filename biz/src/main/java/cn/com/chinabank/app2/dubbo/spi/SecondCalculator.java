package cn.com.chinabank.app2.dubbo.spi;

import cn.com.chinabank.app2.dubbo.api.Calculator;
import com.alibaba.dubbo.common.extension.Adaptive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: baowp
 * Date: 1/9/14
 * Time: 1:33 PM
 */
public class SecondCalculator implements Calculator {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Serializable calculate(String s) {
        logger.info("SecondCalculator.calculate called");
        return getClass().getSimpleName();
    }
}
