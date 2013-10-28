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

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.chinabank.app2.utility.AppConstant;
import cn.com.chinabank.shared.service.DubboSampleService;

import com.alibaba.dubbo.config.annotation.Reference;

/**
 * @author baowp
 *
 */
@Controller
@RequestMapping("dubbo")
public class DubboSampleController {

	@Reference(version = AppConstant.DUBBO_SAMPLE_SERVICE_VERSION)
	private DubboSampleService dubboSampleService;

	@ResponseBody
	@RequestMapping(value = "/entry")
	public Serializable entry(String name) {

		return dubboSampleService.execute(name);
	}
}
