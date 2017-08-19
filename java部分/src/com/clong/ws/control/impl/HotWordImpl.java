package com.clong.ws.control.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clong.ws.control.HotWord;
import com.clong.ws.service.HotWordService;

@Controller
@RequestMapping(value="/HotWord",method=RequestMethod.POST)
public class HotWordImpl implements HotWord {
	@Autowired
	private HotWordService hotWordService;

	/**
	 * 管理端后台-获取导航翻页table
	 * @param page
	 * @param length
	 * @return
	 */
	@RequestMapping("/getPageLimit")
	public @ResponseBody List<Map<String, Object>> getPageLimit(@RequestParam String page, @RequestParam String length) {
		return hotWordService.getPageLimit(page, length);
	}

	/**
	 * 管理端后台-添加导航
	 * @param name
	 * @param sort
	 * @return
	 */
	@RequestMapping("/saveOne")
	public @ResponseBody String saveOne(@RequestParam String name, @RequestParam Integer sort) {
		return hotWordService.saveOne(name, sort);
	}

	/**
	 * 管理端后台-根据id获取
	 * @param id
	 * @return
	 */
	@RequestMapping("/getById")
	public @ResponseBody Map<String, Object> getById(@RequestParam Integer id) {
		return hotWordService.getById(id);
	}

	/**
	 * 管理端后台-修改导航
	 * @param id
	 * @param name
	 * @param sort
	 * @return
	 */
	@RequestMapping("/modifyById")
	public @ResponseBody String modifyById(@RequestParam Integer id, @RequestParam String name,
			@RequestParam Integer sort) {
		return hotWordService.modifyById(id, name, sort);
	}

	/**
	 * 管理端后台-删除导航
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteByIds")
	public @ResponseBody String deleteByIds(@RequestParam String ids) {
		return hotWordService.deleteByIds(ids);
	}
	
	/**
	 * 获取所有
	 */
	@RequestMapping("/getAll")
	public @ResponseBody List<Map<String, Object>> getAll() {
		return hotWordService.getAll();
	}
}
