package com.clong.ws.control;

import java.util.List;
import java.util.Map;

public interface HotWord {
	/**
	 * 用于管理端后台，获取导航翻页，
	 * @param page 第几页
	 * @param length 每页条数
	 * @return [{"allCount":100,"allPage":10,"currentPage":"1"},{"id":1,"name":"JavaScript","sort":1},{"id":2,"name":"php","sort":2},...]
	 */
	List<Map<String, Object>> getPageLimit(String page, String length);
	
	/**
	 * 管理端后台，添加导航
	 * @param name 导航名称
	 * @param sort 导航排序
	 * @return unique：排序不唯一，failure：添加失败，success添加成功
	 */
	String saveOne(String name, Integer sort);
	
	/**
	 * 管理端后台，根据id获取导航
	 * @param id 导航id
	 * @return {"id":1,"name":"1","sort":2}
	 */
	Map<String, Object> getById(Integer id);
	
	/**
	 * 管理端后台，修改导航 
	 * @param id 導航id
	 * @param name 导航名称
	 * @param sort 导航排序
	 * @return unique：排序不唯一，failure：添加失败，success添加成功
	 */
	String modifyById(Integer id, String name, Integer sort);
	
	/**
	 * 管理端后台，删除导航
	 * @param ids 删除导航的id们：1,2,3
	 * @return failure：添加失败，success添加成功
	 */
	String deleteByIds(String ids);
	
	/**
	 * 获取所有
	 * @return
	 */
	List<Map<String, Object>> getAll();
}
