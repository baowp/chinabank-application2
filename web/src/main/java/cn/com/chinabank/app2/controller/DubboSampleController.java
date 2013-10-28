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

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.chinabank.shared.service.DubboSampleService;


/**
 * @author baowp
 *
 */
@Controller
@RequestMapping("dubbo")
public class DubboSampleController {

	@Resource
	private DubboSampleService dubboSampleService;

	@ResponseBody
	@RequestMapping(value = "/entry")
	public Serializable entry(String name) {
		return dubboSampleService.execute(name);
	}
}
