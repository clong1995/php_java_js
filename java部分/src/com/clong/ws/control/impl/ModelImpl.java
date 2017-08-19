package com.clong.ws.control.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clong.ws.control.Model;
import com.clong.ws.service.ModelService;

@Controller
@RequestMapping(value="/Model",method=RequestMethod.POST)
public class ModelImpl implements Model {
	@Autowired
	private ModelService modelService;

	/**
	 * 管理端后台-获取品牌翻页table
	 * @param page
	 * @param length
	 * @return
	 */
	@RequestMapping("/getPageLimit")
	public @ResponseBody List<Map<String, Object>> getPageLimit(@RequestParam String page, @RequestParam String length) {
		return modelService.getPageLimit(page, length);
	}
	
	/**
	 * 后台-添加品牌
	 */
	@RequestMapping("/saveOne")
	public @ResponseBody String saveOne(@RequestParam Integer brand_id, @RequestParam String model_name) {
		return modelService.saveOne(brand_id, model_name);
	}
	
	/**
	 * 管理端后台，根据品牌id型号
	 * @param id 品牌id
	 * @return
	 */
	@RequestMapping("/getById")
	public @ResponseBody List<Map<String, Object>> getById(@RequestParam Integer brand_id) {
		return modelService.getById(brand_id);
	}
	
	/**
	 * 管理端后台-修改型号
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping("/modifyById")
	public @ResponseBody String modifyById(@RequestParam Integer id, @RequestParam String name) {
		return modelService.modifyById(id, name);
	}
	
	/**
	 * 管理端后台-删除型号
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteByIds")
	public @ResponseBody String deleteByIds(@RequestParam String ids) {
		return modelService.deleteByIds(ids);
	}
	
	/**
	 * 获取所有
	 */
	@RequestMapping("/getAll")
	public @ResponseBody List<Map<String, Object>> getAll() {
		return modelService.getAll();
	}
}
