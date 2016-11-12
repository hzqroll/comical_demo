package com.roll.comical.console.business.province.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.roll.comical.console.business.province.ProvinceBuffering;
import com.roll.comical.console.business.province.dao.ProvinceBufferingDao;

/**
 * @author micah.shi
 */
@Repository
public class ProvinceBufferingDaoImpl implements ProvinceBufferingDao {

	@Resource(name = "jellyfishQosMasterSqlMapClientTemplate")
	private SqlMapClientTemplate sqlMapClientTemplate;

	@SuppressWarnings(value = "unchecked")
	@Override
	public List<ProvinceBuffering> getList(int provinceId, Date startDate, Date endDate) {
		Map<String, Object> params = new HashMap<>();
		params.put("provinceId", provinceId);
		params.put("startDate", startDate);
		params.put("endDate", endDate);
		return sqlMapClientTemplate.queryForList("PCProvinceSourceDao.getList", params);
	}
}
