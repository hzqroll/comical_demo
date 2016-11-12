package com.roll.comical.console.business.buffering.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roll.comical.console.business.buffering.DailyBuffering;
import com.roll.comical.console.business.buffering.dao.DailyBufferingDao;
import com.roll.comical.console.business.buffering.service.DailyBufferingService;

/**
 * @author micah.shi
 */
@Service
public class DailyBufferingServiceImpl implements DailyBufferingService {

	@Autowired
	private DailyBufferingDao dailyBufferingDao;
	@Override
	public List<DailyBuffering> getList(Date startDate, Date endDate) {
		return dailyBufferingDao.getList(startDate, endDate);

	}
}
