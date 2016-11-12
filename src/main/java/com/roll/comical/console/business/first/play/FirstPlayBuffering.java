package com.roll.comical.console.business.first.play;

import java.util.Date;

/**
 * 首屏时间对象
 *
 * @author micah.shi
 */
public class FirstPlayBuffering {

	private int sourceId = 0;

	private Date date = null;

	private long bufferTime = 0;

	private long bufferTimeCount = 0;

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

	public long getBufferTime() {
		return bufferTime;
	}

	public void setBufferTime(long bufferTime) {
		this.bufferTime = bufferTime;
	}

	public long getBufferTimeCount() {
		return bufferTimeCount;
	}

	public void setBufferTimeCount(long bufferTimeCount) {
		this.bufferTimeCount = bufferTimeCount;
	}

	@Override
	public String toString() {
		return "FirstPlayBuffering{" +
				"sourceId=" + sourceId +
				", date=" + date +
				", bufferTime=" + bufferTime +
				", bufferTimeCount=" + bufferTimeCount +
				'}';
	}
}
