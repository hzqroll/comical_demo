package com.roll.comical.console.business.buffering.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.roll.comical.console.business.buffering.DailyBuffering;
import com.roll.comical.console.business.buffering.dao.DailyBufferingDao;

/**
 * @author micah.shi
 */
@Repository
public class DailyBufferingDaoImpl implements DailyBufferingDao {

	@Resource(name = "jellyfishQosMasterSqlMapClientTemplate")
	private SqlMapClientTemplate sqlMapClientTemplate;

	@SuppressWarnings(value = "unchecked")
	@Override
	public List<DailyBuffering> getList(Date startDate, Date endDate) {
		Map<String, Object> params = new HashMap<>();
		params.put("startDate", startDate);
		params.put("endDate", endDate);
		return sqlMapClientTemplate.queryForList("PCBufferingSourceDao.getList", params);
	}
}
