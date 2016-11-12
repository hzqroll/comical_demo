package com.roll.comical.console.business.first.play.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roll.comical.console.business.first.play.FirstPlayBuffering;
import com.roll.comical.console.business.first.play.dao.FirstPlayBufferingDao;
import com.roll.comical.console.business.first.play.service.FirstPlayBufferingService;

/**
 * @author micah.shi
 */
@Service
public class FirstPlayBufferingServiceImpl implements FirstPlayBufferingService {

	@Autowired
	private FirstPlayBufferingDao firstPlayBufferingDao;

	@Override
	public List<FirstPlayBuffering> getList(Date startDate, Date endDate) {
		return firstPlayBufferingDao.getList(startDate, endDate);
	}
}
