package com.clong.ws.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ModelDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	/**
	 * 分页获取
	 * @param start
	 * @param length
	 * @return
	 */
	public List<Map<String, Object>> getPageLimit(Integer start, Integer length) {
		String sql = "SELECT brand_id,brand_name,model_name FROM view_model LIMIT :start,:length";
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("start", start);
		paramMap.put("length", length);
		List<Map<String, Object>> rs = this.namedParameterJdbcTemplate.queryForList(sql, paramMap);
		return rs;
	}

	/**
	 * 获取总页数
	 * @return
	 */
	public Map<String, Object> getAllCount() {
		String sql = "SELECT count(*) AS allCount FROM view_model";
		Map<String, String> paramMap = new HashMap<String, String>();
		Map<String, Object> rs = this.namedParameterJdbcTemplate.queryForMap(sql, paramMap);
		return rs;
	}

	/**
	 * 型号后台-防止重复型号名称
	 * @param model_name
	 * @return
	 */
	public Map<String, Object> modelCount(String model_name) {
		String sql = "SELECT count(*) AS modelCount FROM model WHERE name = :model_name";
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("model_name", model_name);
		Map<String, Object> rs = this.namedParameterJdbcTemplate.queryForMap(sql, paramMap);
		return rs;
	}

	/**
	 * 后台-添加型号
	 * @param brand_id
	 * @param model_name
	 * @return
	 */
	public Integer saveOne(Integer brand_id, String model_name) {
		String sql = "INSERT INTO model (brand_id,name) VALUES (:brand_id,:model_name)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("brand_id", brand_id);
		paramMap.put("model_name", model_name);
		Integer rs = this.namedParameterJdbcTemplate.update(sql, paramMap);
		return rs;
	}
	
	/**
	 * 根据品牌id获取型号
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getById(Integer brand_id) {
		String sql = "SELECT id,name FROM model WHERE brand_id = :brand_id";
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("brand_id", brand_id);
		List<Map<String, Object>> rs = this.namedParameterJdbcTemplate.queryForList(sql, paramMap);
		return rs;
	}
	
	/**
	 * 修改型号
	 * @param id
	 * @param name
	 * @return
	 */
	public Integer modifyById(Integer id, String name) {
		String sql = "UPDATE model SET name = :name WHERE id = :id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("name", name);
		Integer rs = this.namedParameterJdbcTemplate.update(sql, paramMap);
		return rs;
	}
	
	/**
	 * 删除品牌
	 * @param idIntList
	 * @return
	 */
	public Integer deleteByIds(List<Integer> idIntList) {
		String sql = "DELETE FROM model  WHERE id in(:ids)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ids", idIntList);
		Integer rs = this.namedParameterJdbcTemplate.update(sql, paramMap);
		return rs;
	}
	
	/**
	 * 分页所有
	 * @return
	 */
	public List<Map<String, Object>> getAll() {
		String sql = "SELECT id,brand_id,name FROM model";
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		List<Map<String, Object>> rs = this.namedParameterJdbcTemplate.queryForList(sql, paramMap);
		return rs;
	}
}
