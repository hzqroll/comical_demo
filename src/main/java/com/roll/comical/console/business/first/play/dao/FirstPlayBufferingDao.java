package com.roll.comical.console.business.first.play.dao;

import java.util.Date;
import java.util.List;

import com.roll.comical.console.business.first.play.FirstPlayBuffering;

/**
 * 首屏时间的时长统计
 *
 * @author micah.shi
 */
public interface FirstPlayBufferingDao {

	public List<FirstPlayBuffering> getList(Date startDate, Date endDate);
}
