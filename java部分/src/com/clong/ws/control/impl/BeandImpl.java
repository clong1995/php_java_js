package com.clong.ws.control.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clong.ws.control.Brand;
import com.clong.ws.service.BrandService;

@Controller
@RequestMapping(value="/Brand",method=RequestMethod.POST)
public class BeandImpl implements Brand {
	@Autowired
	private BrandService brandService;

	/**
	 * 管理端后台-获取品牌翻页table
	 * @param page
	 * @param length
	 * @return
	 */
	@RequestMapping("/getPageLimit")
	public @ResponseBody List<Map<String, Object>> getPageLimit(@RequestParam String page, @RequestParam String length) {
		return brandService.getPageLimit(page, length);
	}

	/**
	 * 管理端后台-添加品牌
	 * @param name
	 * @param sort
	 * @return
	 */
	@RequestMapping("/saveOne")
	public @ResponseBody String saveOne(@RequestParam String name, @RequestParam Integer sort) {
		return brandService.saveOne(name, sort);
	}

	/**
	 * 管理端后台-根据id获取
	 * @param id
	 * @return
	 */
	@RequestMapping("/getById")
	public @ResponseBody Map<String, Object> getById(@RequestParam Integer id) {
		return brandService.getById(id);
	}

	/**
	 * 管理端后台-修改品牌
	 * @param id
	 * @param name
	 * @param sort
	 * @return
	 */
	@RequestMapping("/modifyById")
	public @ResponseBody String modifyById(@RequestParam Integer id, @RequestParam String name,
			@RequestParam Integer sort) {
		return brandService.modifyById(id, name, sort);
	}

	/**
	 * 管理端后台-删除品牌
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteByIds")
	public @ResponseBody String deleteByIds(@RequestParam String ids) {
		return brandService.deleteByIds(ids);
	}
	
	/**
	 * 获取所有
	 */
	@RequestMapping("/getAll")
	public @ResponseBody List<Map<String, Object>> getAll() {
		return brandService.getAll();
	}
}
