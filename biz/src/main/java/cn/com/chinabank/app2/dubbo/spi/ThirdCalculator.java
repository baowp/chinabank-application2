package cn.com.chinabank.app2.dubbo.spi;

import cn.com.chinabank.app2.dubbo.api.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: baowp
 * Date: 1/22/14
 * Time: 2:53 PM
 */
public class ThirdCalculator implements Calculator {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Serializable calculate(String s) {
        logger.info("ThirdCalculator.calculate called");
        return getClass().getSimpleName();
    }
}
