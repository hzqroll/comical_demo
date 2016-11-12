package com.roll.comical.console.business.province.dao;

import java.util.Date;
import java.util.List;

import com.roll.comical.console.business.province.ProvinceBuffering;

/**
 * @author micah.shi
 */
public interface ProvinceBufferingDao {
	public List<ProvinceBuffering> getList(int provinceId, Date startDate, Date endDate);
}
