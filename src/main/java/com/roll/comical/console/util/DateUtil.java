package com.roll.comical.console.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间转换工具类
 * 建议使用jdk1.8的方法,线程安全
 *
 * @author micah.shi
 */
public final class DateUtil {
	/**
	 * 获取当前分钟时间的long类型(单位为秒)
	 *
	 * @return unix timestamp(单位为秒)
	 */
	public static long getBufferingUnixTimestamp() {
		// 获取当前时间分级别LocalDateTime
		LocalDateTime localDateTime = LocalDateTime.now().withSecond(0).withNano(0);
		localDateTime = localDateTime.withMinute(localDateTime.getMinute() / 5 * 5);

		return localDateTime.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
	}


	/**
	 * 获取当前分钟时间的long类型(单位为秒)
	 *
	 * @return unix timestamp(单位为秒)
	 */
	public static long getFirstPlayUnixTimestamp() {
		// 获取当前时间分级别LocalDateTime
		LocalDateTime localDateTime = LocalDateTime.now().withSecond(0).withNano(0);
		localDateTime = localDateTime.withMinute(localDateTime.getMinute() / 5 * 5);

		return localDateTime.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
	}

	/**
	 * 获取明天的时间
	 *
	 * @return 明天的时间
	 */
	public static LocalDate getTomorrowDay() {
		return LocalDate.now().plusDays(1);
	}

	/** 获取昨天的日期
	 * @return 昨天的日期
	 */
	public static LocalDate getYesterday() {
		return LocalDate.now().minusDays(1);
	}

	public static List<Date> getTimeGapDayList(Date startDate, Date endDate) {
		return getTimeGapDateList(startDate, endDate, 60*24);
	}

	public static List<Date> getTimeGapDateList(Date startDate, Date endDate, int gapMinute) {
		List<Date> dateList = new ArrayList<>();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);

		Date lastDate = startDate;
		while (calendar.getTimeInMillis() < endDate.getTime()) {
			Date currentDate = calendar.getTime();
			dateList.add(currentDate);
			lastDate = currentDate;
			calendar.add(Calendar.MINUTE, gapMinute);
		}

		if (lastDate.before(endDate)) {
			dateList.add(endDate);
		}

		return dateList;
	}
}
