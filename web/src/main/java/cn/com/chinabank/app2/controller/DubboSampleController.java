/**
 * Project: application2.web
 *
 * File Created at Oct 25, 2013
 * $Id$ Corporation
 *
 * Copyright 2013-2019 Chinabank.com.cn Corporation Limited.
 * All rights reserved.
 */
package cn.com.chinabank.app2.controller;

import cn.com.chinabank.shared.listener.CallbackListener;
import cn.com.chinabank.shared.service.CallbackService;
import cn.com.chinabank.shared.service.DubboSampleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.Serializable;


/**
 * @author baowp
 */
@Controller
@RequestMapping("dubbo")
public class DubboSampleController {

    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger
            .getLogger(getClass());

    @Resource
    private DubboSampleService dubboSampleService;
    @Resource
    private CallbackService callbackService;

    @ResponseBody
    @RequestMapping(value = "/entry")
    public Serializable entry(String name) {
        return dubboSampleService.execute(name);
    }

    @ResponseBody
    @RequestMapping(value = "/examine")
    public Object examine() {
       Object obj= callbackService.addListener("foo.bar", new CallbackListener(){
            public void changed(String msg) {
                System.out.println("callback1:" + msg);
            }
        });
        logger.info(obj);
        return obj;
    }


}
