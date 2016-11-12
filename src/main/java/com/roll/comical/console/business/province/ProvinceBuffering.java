package com.roll.comical.console.business.province;

import java.util.Date;

/**
 * 首屏时间对象
 *
 * @author micah.shi
 */
public class ProvinceBuffering {

	private int provinceId = 0;

	private int sourceId = 0;

	private Date date = null;

	private long bufferingCount = 0;

	private long fluencyCount = 0;

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getBufferingCount() {
		return bufferingCount;
	}

	public void setBufferingCount(long bufferingCount) {
		this.bufferingCount = bufferingCount;
	}

	public long getFluencyCount() {
		return fluencyCount;
	}

	public void setFluencyCount(long fluencyCount) {
		this.fluencyCount = fluencyCount;
	}

	@Override
	public String toString() {
		return "ProvinceBuffering{" +
				"provinceId=" + provinceId +
				", sourceId=" + sourceId +
				", date=" + date +
				", bufferingCount=" + bufferingCount +
				", fluencyCount=" + fluencyCount +
				'}';
	}
}
