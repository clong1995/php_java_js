package com.clong.ws.control;

import java.util.List;
import java.util.Map;

public interface SearchWord {
	/**
	 * 用于管理端后台，获取搜索关键词的翻页，
	 * @param page 第几页
	 * @param length 每页条数
	 * @return [{"allCount":100,"allPage":10,"currentPage":"1"},{"id":1,"name":"JavaScript","sort":1},{"id":2,"name":"php","sort":2},...]
	 */
	List<Map<String, Object>> getSearchWordLimit(String page, String length);
}
