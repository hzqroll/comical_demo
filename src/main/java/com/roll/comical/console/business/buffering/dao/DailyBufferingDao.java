package com.roll.comical.console.business.buffering.dao;

import java.util.Date;
import java.util.List;

import com.roll.comical.console.business.buffering.DailyBuffering;

/**
 * @author micah.shi
 */
public interface DailyBufferingDao {
	public List<DailyBuffering> getList(Date startDate, Date endDate);
}
