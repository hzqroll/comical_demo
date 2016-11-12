package com.roll.comical.console.business.stream.firstplay.platformsource;

import java.util.Date;

/**
 * @author zongqiang.hao
 */
public class PlatformSourceFirstplay {
    private Date date = null;

    private int platformId = 0;

    private int sourceId = 0;

    private long bufferTime = 0;

    private long bufferTimeCount = 0;


    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
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
        return "PlatformSourceFirstplay{" +
                ", date=" + date +
                ", platformId=" + platformId +
                ", sourceId=" + sourceId +
                ", bufferTime=" + bufferTime +
                ", bufferTimeCount=" + bufferTimeCount +
                '}';
    }
}
