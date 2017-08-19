package com.clong.ws.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SearchWordDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * 分页获取
	 * @param start
	 * @param length
	 * @return
	 */
	public List<Map<String, Object>> getSearchWordLimit(Integer start, Integer length) {
		String sql = "SELECT time,userid,word FROM search_word ORDER BY time DESC LIMIT :start,:length";
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
		String sql = "SELECT count(*) AS allCount FROM search_word";
		Map<String, String> paramMap = new HashMap<String, String>();
		Map<String, Object> rs = this.namedParameterJdbcTemplate.queryForMap(sql, paramMap);
		return rs;
	}
}
