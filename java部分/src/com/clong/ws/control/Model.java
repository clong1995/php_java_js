package com.clong.ws.control;

import java.util.List;
import java.util.Map;

public interface Model {
	
	/**
	 * 用于管理端后台，获取型号翻页，
	 * @param page 第几页
	 * @param length 每页条数
	 * @return [{"allCount":100,"allPage":10,"currentPage":"1"},{"id":1,"name":"JavaScript","sort":1},{"id":2,"name":"php","sort":2},...]
	 */
	List<Map<String, Object>> getPageLimit(String page, String length);
	
	/**
	 * 管理端后台，添加型号
	 * @param brand_id 品牌id
	 * @param model_name 型号名称
	 * @return unique：排序不唯一，failure：添加失败，success添加成功
	 */
	String saveOne(Integer brand_id, String model_name);
	
	/**
	 * 管理端后台，根据品牌id型号
	 * @param id 品牌id
	 * @return {"id":1,"name":"1","sort":2}
	 */
	List<Map<String, Object>> getById(Integer brand_id);
	
	/**
	 * 管理端后台，根据id修改型号 
	 * @param id 型号id
	 * @param name 型号名称
	 * @return unique：排序不唯一，failure：添加失败，success添加成功
	 */
	String modifyById(Integer id, String name);
	
	/**
	 * 管理端后台，删除型号
	 * @param ids 删除品牌的id们：1,2,3
	 * @return failure：添加失败，success添加成功
	 */
	String deleteByIds(String ids);
	
	/**
	 * 获取所有
	 * @return
	 */
	List<Map<String, Object>> getAll();
}
