package cn.com.chinabank.app2.dubbo.api;

import com.alibaba.dubbo.common.extension.SPI;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: baowp
 * Date: 1/9/14
 * Time: 1:32 PM
 */
@SPI
public interface Calculator {

    Serializable calculate(String s);
}
