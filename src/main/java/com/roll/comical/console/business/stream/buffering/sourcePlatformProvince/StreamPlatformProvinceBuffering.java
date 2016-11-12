package com.roll.comical.console.business.stream.buffering.sourcePlatformProvince;

import java.util.Date;

/**
 * @author zongqiang.hao
 */
public class StreamPlatformProvinceBuffering {
    private Date date = null;

    private int platformId = 0;

    private int provinceId = 330000;

    private long bufferingCount = 0;

    private long fluencyCount = 0;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
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
}
