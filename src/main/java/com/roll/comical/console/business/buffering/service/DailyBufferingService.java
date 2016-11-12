package com.roll.comical.console.business.buffering.service;

import java.util.Date;
import java.util.List;

import com.roll.comical.console.business.buffering.DailyBuffering;

/**
 * @author micah.shi
 */
public interface DailyBufferingService {
	public List<DailyBuffering> getList(Date startDate, Date endDate);
}
