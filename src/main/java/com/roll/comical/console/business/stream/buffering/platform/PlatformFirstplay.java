package com.roll.comical.console.business.stream.buffering.platform;

import java.util.Date;

/**
 * @author zongqiang.hao
 */
public class PlatformFirstplay {

    private int platformId = 0;

    private Date date = null;

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    private long bufferTime = 0;

    private long bufferTimeCount = 0;

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
        return "PLatformFirstplay{" +
                "sourceId=" + platformId +
                ", date=" + date +
                ", bufferTime=" + bufferTime +
                ", bufferTimeCount=" + bufferTimeCount +
                '}';
    }
}
