package com.clong.ws.control;

import java.util.List;
import java.util.Map;

public interface Product {
	
	/**
	 * 用于前台，获取产品翻页，
	 * @param page 第几页
	 * @param length 每页条数
	 * @return [{"allCount":100,"allPage":10,"currentPage":"1"},{"id":1,"name":"JavaScript","sort":1},{"id":2,"name":"php","sort":2},...]
	 */
	List<Map<String, Object>> getPageLimit(String page, String length);
	
	/**
	 * 用于后台，获取产品翻页，
	 * @param page 第几页
	 * @param length 每页条数
	 * @return [{"allCount":100,"allPage":10,"currentPage":"1"},{"id":1,"name":"JavaScript","sort":1},{"id":2,"name":"php","sort":2},...]
	 */
	List<Map<String, Object>> getPageLimitForAdmin(String page, String length);
	
	/**
	 * 管理端后台，添加产品
	 * @param name 产品名称
	 * @param sort 产品排序
	 * @return unique：排序不唯一，failure：添加失败，success添加成功
	 */
	String saveOne(String title, Integer price, Integer brand_id, String model, Integer sort);
	
	/**
	 * 管理端后台，根据id获取产品
	 * @param id 产品id
	 * @return {"id":1,"name":"1","sort":2}
	 */
	Map<String, Object> getById(Integer id);
	
	/**
	 * 管理端后台，修改产品 
	 * @param id 導航id
	 * @param name 产品名称
	 * @param sort 产品排序
	 * @return unique：排序不唯一，failure：添加失败，success添加成功
	 */
	String modifyById(Integer id, String title, Integer price, Integer brand_id, String model,Integer sort);
	
	/**
	 * 管理端后台，删除产品
	 * @param ids 删除产品的id们：1,2,3
	 * @return failure：添加失败，success添加成功
	 */
	String deleteByIds(String ids);
}
