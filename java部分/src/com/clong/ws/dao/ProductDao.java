package com.clong.ws.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * 添加导航
	 * 
	 * @param name
	 * @param sort
	 * @return
	 */
	public Integer saveOne(String title, Integer price, Integer brand_id, String model, Integer sort) {
		String sql = "INSERT INTO product (title,price,brand_id,model_id,sort) VALUES (:title,:price,:brand_id,:model,:sort)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", title);
		paramMap.put("price", price);
		paramMap.put("brand_id", brand_id);
		paramMap.put("model", model);
		paramMap.put("sort", sort);
		Integer rs = this.namedParameterJdbcTemplate.update(sql, paramMap);
		return rs;
	}

	/**
	 * 根据id获取导航
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> getById(Integer id) {
		String sql = "SELECT id,title,price,brand_id,model_id,time,sort FROM product WHERE id = :id";
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("id", id);
		Map<String, Object> rs = this.namedParameterJdbcTemplate.queryForMap(sql, paramMap);
		return rs;
	}

	/**
	 * 分页获取
	 * 
	 * @param start
	 * @param length
	 * @return
	 */
	public List<Map<String, Object>> getPageLimit(Integer start, Integer length) {
		String sql = "SELECT id,title,price,brand,model,comment_sum,sort,img_name FROM view_product ORDER BY sort ASC LIMIT :start,:length";
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("start", start);
		paramMap.put("length", length);
		List<Map<String, Object>> rs = this.namedParameterJdbcTemplate.queryForList(sql, paramMap);
		return rs;
	}
	
	/**
	 * 后台分页获取
	 * 
	 * @param start
	 * @param length
	 * @return
	 */
	public List<Map<String, Object>> getPageLimitForAdmin(Integer start, Integer length) {
		String sql = "SELECT id,time,title,price,sort FROM product ORDER BY sort ASC LIMIT :start,:length";
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("start", start);
		paramMap.put("length", length);
		List<Map<String, Object>> rs = this.namedParameterJdbcTemplate.queryForList(sql, paramMap);
		return rs;
	}

	/**
	 * 获取总页数
	 * 
	 * @return
	 */
	public Map<String, Object> getAllCount() {
		String sql = "SELECT count(*) AS allCount FROM product";
		Map<String, String> paramMap = new HashMap<String, String>();
		Map<String, Object> rs = this.namedParameterJdbcTemplate.queryForMap(sql, paramMap);
		return rs;
	}

	/**
	 * 查询唯一的排序
	 * 
	 * @param sort
	 * @param id
	 * @return
	 */
	public Map<String, Object> sortCount(Integer sort, Integer id) {
		String sql = "SELECT count(*) AS sortCount FROM product WHERE sort = :sort AND id != :id";
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("sort", sort);
		paramMap.put("id", id);
		Map<String, Object> rs = this.namedParameterJdbcTemplate.queryForMap(sql, paramMap);
		return rs;
	}

	/**
	 * 查询唯一的排序
	 * 
	 * @param sort
	 * @return
	 */
	public Map<String, Object> sortCount(Integer sort) {
		String sql = "SELECT count(*) AS sortCount FROM product WHERE sort = :sort";
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("sort", sort);
		Map<String, Object> rs = this.namedParameterJdbcTemplate.queryForMap(sql, paramMap);
		return rs;
	}

	/**
	 * 修改导航
	 * 
	 * @param id
	 * @param name
	 * @param sort
	 * @return
	 */
	public Integer modifyById(Integer id, String title, Integer price, Integer brand_id, String model_id, Integer sort) {
		String sql = "UPDATE product SET title = :title,price = :price,brand_id = :brand_id,model_id = :model_id,sort = :sort WHERE id = :id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("title", title);
		paramMap.put("price", price);
		paramMap.put("brand_id", brand_id);
		paramMap.put("model_id", model_id);
		paramMap.put("sort", sort);
		Integer rs = this.namedParameterJdbcTemplate.update(sql, paramMap);
		return rs;
	}

	/**
	 * 删除导航
	 * 
	 * @param idIntList
	 * @return
	 */
	public Integer deleteByIds(List<Integer> idIntList) {
		String sql = "DELETE FROM product  WHERE id in(:ids)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ids", idIntList);
		Integer rs = this.namedParameterJdbcTemplate.update(sql, paramMap);
		return rs;
	}
}
