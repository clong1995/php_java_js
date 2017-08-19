package com.clong.ws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clong.ws.dao.ModelDao;

@Service
public class ModelService {
	@Autowired
	private ModelDao modelDao;

	/**
	 * 分页获取导航
	 * 
	 * @param page
	 * @param length
	 * @return
	 */
	public List<Map<String, Object>> getPageLimit(String page, String length) {
		List<Map<String, Object>> rsList = new ArrayList<>();
		if (page.isEmpty()) {
			page = "0";
		} else {
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(page);
			if (!isNum.matches()) {
				page = "0";
			}
		}

		if (page != "0") {
			int pageInt = Integer.parseInt(page);
			int lengthInt = Integer.parseInt(length);

			// 总页数可分多少页
			Map<String, Object> infoMap = this.modelDao.getAllCount();
			Long allCount = (Long) infoMap.get("allCount");
			double allPage = (double) allCount.intValue() / lengthInt;
			infoMap.put("allPage", (int) Math.ceil(allPage));
			infoMap.put("currentPage", page);

			// 开始位置
			rsList.add(infoMap);
			int start = lengthInt * (pageInt - 1);

			// 正文
			List<Map<String, Object>> navList = this.modelDao.getPageLimit(start, lengthInt);
			rsList.addAll(navList);
		}
		return rsList;
	}
	
	/**
	 * 后台-添加型号
	 * @param brand_id
	 * @param model_name
	 * @return
	 */
	public String saveOne(Integer brand_id, String model_name) {
		// 排序是否重复
		Map<String, Object> modelCount = this.modelDao.modelCount(model_name);
		if ((Long) modelCount.get("modelCount") > 0) {
			return "unique";
		}
		// 是否插入成功
		Integer lines = this.modelDao.saveOne(brand_id, model_name);
		if (lines <= 0) {
			return "failure";
		}
		return "success";
	}
	
	/**
	 * 根据品牌id获取型号
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getById(Integer brand_id) {
		return this.modelDao.getById(brand_id);
	}
	
	/**
	 * 修改导航
	 * @param id
	 * @param name
	 * @param sort
	 * @return
	 */
	public String modifyById(Integer id, String name) {
		// 排序是否重复
		Map<String, Object> modelCount = this.modelDao.modelCount(name);
		if ((Long) modelCount.get("modelCount") > 0) {
			return "unique";
		}
		// 是否插入成功
		Integer lines = this.modelDao.modifyById(id, name);
		if (lines <= 0) {
			return "failure";
		}
		return "success";
	}
	
	/**
	 * 删除导航
	 * @param ids
	 * @return
	 */
	public String deleteByIds(String ids) {
		//TODO查询这个导航下是否有文章
		
		//删除操作
		String[] idsStringArr = ids.split(",");
		List<Integer> idIntList = new ArrayList<Integer>();
		for(String id:idsStringArr){ 
			idIntList.add(Integer.parseInt(id));
		}
		
		Integer lines = this.modelDao.deleteByIds(idIntList);
		if (lines <= 0) {
			return "failure";
		}
		return "success";
	}
	
	/**
	 * 获取所有
	 * @return
	 */
	public List<Map<String, Object>> getAll() {
		// 正文
		List<Map<String, Object>> navList = this.modelDao.getAll();
		return navList;
	}
}
