package com.clong.ws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clong.ws.dao.SearchWordDao;

@Service
public class SearchWordService {
	@Autowired
	private SearchWordDao searchWordDao;
	
	/**
	 * 分页获取导航
	 * @param page
	 * @param length
	 * @return
	 */
	public List<Map<String, Object>> getSearchWordLimit(String page, String length) {
		List<Map<String, Object>> rsList = new ArrayList<>();
		if (page.isEmpty()) {
			page = "1";
		} else {
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(page);
			if (!isNum.matches()) {
				page = "1";
			}
		}
		
		int pageInt = Integer.parseInt(page);
		int lengthInt = Integer.parseInt(length);

		// 总页数可分多少页
		Map<String, Object> infoMap = this.searchWordDao.getAllCount();
		Long allCount = (Long) infoMap.get("allCount");
		double allPage = (double) allCount.intValue() / lengthInt;
		infoMap.put("allPage", (int) Math.ceil(allPage));
		infoMap.put("currentPage", page);

		// 开始位置
		rsList.add(infoMap);
		int start = lengthInt * (pageInt - 1);

		// 正文
		List<Map<String, Object>> searchWordList = this.searchWordDao.getSearchWordLimit(start, lengthInt);
		rsList.addAll(searchWordList);

		return rsList;
	}
}
