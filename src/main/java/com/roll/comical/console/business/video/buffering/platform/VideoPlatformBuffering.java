package com.roll.comical.console.business.video.buffering.platform;

import java.util.Date;

/**
 * @author zongqiang.hao
 */
public class VideoPlatformBuffering {

    private Date date = null;

    private int platformId = 0;

    private long bufferingCount = 0;

    private long fluencyCount = 0;


    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
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
        return "PlatformBuffering{" +
                ", date=" + date +
                "platformId=" + platformId +
                ", bufferingCount=" + bufferingCount +
                ", fluencyCount=" + fluencyCount +
                '}';
    }
}
