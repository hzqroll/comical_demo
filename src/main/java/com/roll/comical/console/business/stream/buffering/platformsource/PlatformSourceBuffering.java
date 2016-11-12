package com.roll.comical.console.business.stream.buffering.platformsource;

import java.util.Date;

/**
 * @author zongqiang.hao
 */
public class PlatformSourceBuffering {
    private Date date = null;

    private int platformId = 0;

    private int sourceId = 0;

    private long bufferingCount = 0;

    private long fluencyCount = 0;


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
        return "PlatformSourceBuffering{" +
                ", date=" + date +
                "platformId=" + platformId +
                "sourceId=" + sourceId +
                ", bufferingCount=" + bufferingCount +
                ", fluencyCount=" + fluencyCount +
                '}';
    }
}
