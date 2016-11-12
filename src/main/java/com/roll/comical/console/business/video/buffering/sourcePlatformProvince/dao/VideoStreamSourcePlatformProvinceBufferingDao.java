package com.roll.comical.console.business.video.buffering.sourcePlatformProvince.dao;

import java.util.Date;
import java.util.List;

import com.roll.comical.console.business.video.buffering.sourcePlatformProvince.VideoSourcePlatformProvinceBuffering;

/**
 * @author zongqiang.hao
 */
public interface VideoStreamSourcePlatformProvinceBufferingDao {
    public List<VideoSourcePlatformProvinceBuffering> getList(int sourceId, Date startDate, Date endDate);

    public List<VideoSourcePlatformProvinceBuffering> getProvinceList(int sourceId, int platformId, String nowDate);

    public List<VideoSourcePlatformProvinceBuffering> getAllList(String nowDate);
}
