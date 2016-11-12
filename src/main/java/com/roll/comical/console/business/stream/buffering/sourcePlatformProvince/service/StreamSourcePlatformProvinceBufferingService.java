package com.roll.comical.console.business.stream.buffering.sourcePlatformProvince.service;

import java.util.Date;
import java.util.List;

import com.roll.comical.console.business.stream.buffering.sourcePlatformProvince.StreamSourcePlatformProvinceBuffering;

/**
 * @author zongqiang.hao
 */
public interface StreamSourcePlatformProvinceBufferingService {
    public List<StreamSourcePlatformProvinceBuffering> getList(int sourceId, Date startDate, Date endDate);

    public List<StreamSourcePlatformProvinceBuffering> getProvinceList(int sourceId, int platformId, String nowDate);

    public List<StreamSourcePlatformProvinceBuffering> getAllList(String nowDate);
}
