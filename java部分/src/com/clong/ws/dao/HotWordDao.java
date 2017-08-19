package com.clong.ws.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HotWordDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * 添加导航
	 * @param name
	 * @param sort
	 * @return
	 */
	public Integer saveOne(String name, Integer sort) {
		String sql = "INSERT INTO HotWord (name,sort) VALUES (:name,:sort)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", name);
		paramMap.put("sort", sort);
		Integer rs = this.namedParameterJdbcTemplate.update(sql, paramMap);
		return rs;
	}
	
	/**
	 * 根据id获取导航
	 * @param id
	 * @return
	 */
	public Map<String, Object> getById(Integer id) {
		String sql = "SELECT id,name,sort FROM HotWord WHERE id = :id";
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("id", id);
		Map<String, Object> rs = this.namedParameterJdbcTemplate.queryForMap(sql, paramMap);
		return rs;
	}

	/**
	 * 分页获取
	 * @param start
	 * @param length
	 * @return
	 */
	public List<Map<String, Object>> getPageLimit(Integer start, Integer length) {
		String sql = "SELECT id,name,sort FROM HotWord ORDER BY sort ASC LIMIT :start,:length";
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
		String sql = "SELECT count(*) AS allCount FROM HotWord";
		Map<String, String> paramMap = new HashMap<String, String>();
		Map<String, Object> rs = this.namedParameterJdbcTemplate.queryForMap(sql, paramMap);
		return rs;
	}

	/**
	 * 查询唯一的排序
	 * @param sort
	 * @param id
	 * @return
	 */
	public Map<String, Object> sortCount(Integer sort, Integer id) {
		String sql = "SELECT count(*) AS sortCount FROM HotWord WHERE sort = :sort AND id != :id";
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("sort", sort);
		paramMap.put("id", id);
		Map<String, Object> rs = this.namedParameterJdbcTemplate.queryForMap(sql, paramMap);
		return rs;
	}

	/**
	 * 查询唯一的排序
	 * @param sort
	 * @return
	 */
	public Map<String, Object> sortCount(Integer sort) {
		String sql = "SELECT count(*) AS sortCount FROM HotWord WHERE sort = :sort";
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("sort", sort);
		Map<String, Object> rs = this.namedParameterJdbcTemplate.queryForMap(sql, paramMap);
		return rs;
	}

	/**
	 * 修改导航
	 * @param id
	 * @param name
	 * @param sort
	 * @return
	 */
	public Integer modifyById(Integer id, String name, Integer sort) {
		String sql = "UPDATE HotWord SET name = :name,sort = :sort WHERE id = :id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("name", name);
		paramMap.put("sort", sort);
		Integer rs = this.namedParameterJdbcTemplate.update(sql, paramMap);
		return rs;
	}
	
	/**
	 * 删除导航
	 * @param idIntList
	 * @return
	 */
	public Integer deleteByIds(List<Integer> idIntList) {
		String sql = "DELETE FROM HotWord  WHERE id in(:ids)";
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
		String sql = "SELECT id,name,sort FROM HotWord ORDER BY sort ASC";
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		List<Map<String, Object>> rs = this.namedParameterJdbcTemplate.queryForList(sql, paramMap);
		return rs;
	}
}
