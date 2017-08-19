package com.clong.ws.control.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginImpl {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> login(@RequestParam String id, @RequestParam String password) {
		//调用dao
		Map<String,String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password",password);
		return map;
	}
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> userLogin(@RequestParam String id, @RequestParam String password) {
		//调用dao
		Map<String,String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password",password);
		return map;
	}
	
	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> adminLogin(@RequestParam String id, @RequestParam String password) {
		//调用dao
		Map<String,String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password",password);
		return map;
	}
	
}
