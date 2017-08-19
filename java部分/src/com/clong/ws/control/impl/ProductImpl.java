package com.clong.ws.control.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clong.ws.control.Product;
import com.clong.ws.service.ProductService;

@Controller
@RequestMapping(value="/Product",method=RequestMethod.POST)
public class ProductImpl implements Product {
	@Autowired
	private ProductService productService;
	

	/**
	 * 后台-获取导航翻页table
	 * @param page
	 * @param length
	 * @return
	 */
	@RequestMapping("/getPageLimitForAdmin")
	public @ResponseBody List<Map<String, Object>> getPageLimitForAdmin(@RequestParam String page, @RequestParam String length) {
		return productService.getPageLimitForAdmin(page, length);
	}
	
	/**
	 * 前端-获取导航翻页table
	 * @param page
	 * @param length
	 * @return
	 */
	@RequestMapping("/getPageLimit")
	public @ResponseBody List<Map<String, Object>> getPageLimit(@RequestParam String page, @RequestParam String length) {
		return productService.getPageLimit(page, length);
	}

	/**
	 * 管理端后台-添加导航
	 * @param name
	 * @param sort
	 * @return
	 */
	@RequestMapping("/saveOne")
	public @ResponseBody String saveOne(@RequestParam String title, @RequestParam Integer price, @RequestParam Integer brand_id, @RequestParam String model, @RequestParam Integer sort) {
		return productService.saveOne(title, price, brand_id, model, sort);
	}

	/**
	 * 管理端后台-根据id获取
	 * @param id
	 * @return
	 */
	@RequestMapping("/getById")
	public @ResponseBody Map<String, Object> getById(@RequestParam Integer id) {
		return productService.getById(id);
	}

	/**
	 * 管理端后台-修改导航
	 * @param id
	 * @param name
	 * @param sort
	 * @return
	 */
	@RequestMapping("/modifyById")
	public @ResponseBody String modifyById(@RequestParam Integer id, @RequestParam String title, @RequestParam Integer price, @RequestParam Integer brand_id, @RequestParam String model, @RequestParam Integer sort) {
		return productService.modifyById(id, title, price, brand_id, model, sort);
	}

	/**
	 * 管理端后台-删除导航
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteByIds")
	public @ResponseBody String deleteByIds(@RequestParam String ids) {
		return productService.deleteByIds(ids);
	}
}
