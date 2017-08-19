package com.clong.ws.control.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clong.ws.control.SearchWord;
import com.clong.ws.service.SearchWordService;

@Controller
@RequestMapping(value="/SearchWord",method=RequestMethod.POST)
public class SearchWordImpl implements SearchWord {
	@Autowired
	private SearchWordService searchWordService;
	
	/**
	 * 管理端后台-获取导航翻页table
	 * @param page
	 * @param length
	 * @return
	 */
	@Override
	@RequestMapping("/getSearchWordLimit")
	public @ResponseBody List<Map<String, Object>> getSearchWordLimit(@RequestParam String page, @RequestParam String length) {
		return searchWordService.getSearchWordLimit(page, length);
	}

}
