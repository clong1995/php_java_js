package com.clong.ws.control.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class Test {
	// http://127.0.0.1:8080/SpringRESTfulWS/test/json?id=1&name=2
	@RequestMapping(value = "/json", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> getJson(@RequestParam String id, @RequestParam String name) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("name", name);
		return map;
	}
	
	//测试没有返回值得情况
	@RequestMapping(value = "/test1", method = RequestMethod.POST)
	public @ResponseBody void test1(@RequestParam String id, @RequestParam String name) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("name", name);
		System.out.println(id);
		/*
		try {
			Thread.currentThread();
			Thread.sleep(60000);// 毫秒
		} catch (Exception e) {
		}
		*/
	}
}
