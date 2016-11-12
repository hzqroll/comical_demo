package com.roll.comical.console.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换工具类
 *
 * @author micah.shi
 */
public final class DateStringUtil {

	public static String format(Date date) {
		return format(date, "yyyy-MM-dd");
	}


	private static String format(Date date, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} catch (Exception e) {
			// nothing to do
		}
		return "";
	}
}
