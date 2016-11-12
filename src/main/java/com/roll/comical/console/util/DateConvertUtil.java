package com.roll.comical.console.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author micah.shi
 */
public final class DateConvertUtil {

	public static LocalDate asLocalDate(Date date) {
		return asLocalDate(date, ZoneId.systemDefault());
	}

	private static LocalDate asLocalDate(Date date, ZoneId zone) {
		if (date == null)
			return null;

		return Instant.ofEpochMilli(date.getTime()).atZone(zone).toLocalDate();
	}

	public static LocalDateTime asLocalDateTime(Date date) {
		return asLocalDateTime(date, ZoneId.systemDefault());
	}

	private static LocalDateTime asLocalDateTime(Date date, ZoneId zone) {
		if (date == null)
			return null;
		return Instant.ofEpochMilli(date.getTime()).atZone(zone).toLocalDateTime();
	}

	public static Instant asInstant(Date date) {
		if (date == null)
			return null;
		else
			return Instant.ofEpochMilli(date.getTime());
	}

	public static ZonedDateTime asZonedDateTime(Date date) {
		return asZonedDateTime(date, ZoneId.systemDefault());
	}

	private static ZonedDateTime asZonedDateTime(Date date, ZoneId zone) {
		if (date == null)
			return null;
		else
			return asInstant(date).atZone(zone);
	}

	public static Date asDate(Object date) {
		return asUtilDate(date, ZoneId.systemDefault());
	}

	private static Date asUtilDate(Object date, ZoneId zone) {
		if (date == null)
			return null;

		if (date instanceof java.sql.Date || date instanceof java.sql.Timestamp)
			return new Date(((Date) date).getTime());
		if (date instanceof Date)
			return (Date) date;
		if (date instanceof LocalDate)
			return Date.from(((LocalDate) date).atStartOfDay(zone).toInstant());
		if (date instanceof LocalDateTime)
			return Date.from(((LocalDateTime) date).atZone(zone).toInstant());
		if (date instanceof ZonedDateTime)
			return Date.from(((ZonedDateTime) date).toInstant());
		if (date instanceof Instant)
			return Date.from((Instant) date);

		throw new UnsupportedOperationException("Don't know hot to convert " + date.getClass().getName() + " to Date");
	}
}
