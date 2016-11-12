package com.roll.comical.console.business.first.play.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.roll.comical.console.business.first.play.FirstPlayBuffering;
import com.roll.comical.console.business.first.play.dao.FirstPlayBufferingDao;

/**
 * @author micah.shi
 */
@Repository
public class FirstPlayBufferingDaoImpl implements FirstPlayBufferingDao {

	@Resource(name = "jellyfishQosMasterSqlMapClientTemplate")
	private SqlMapClientTemplate sqlMapClientTemplate;

	@SuppressWarnings(value = "unchecked")
	@Override
	public List<FirstPlayBuffering> getList(Date startDate, Date endDate) {

		Map<String, Object> params = new HashMap<>();
		params.put("startDate", startDate);
		params.put("endDate", endDate);
		return sqlMapClientTemplate.queryForList("PCFirstPlayBufferingDao.getList", params);
	}
}
