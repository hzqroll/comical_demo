package com.roll.comical.console.business.stream.firstplay.sourcePlatformProvince.dao;

import java.util.Date;
import java.util.List;

import com.roll.comical.console.business.stream.firstplay.sourcePlatformProvince.StreamSourcePlatformProvinceFirstplay;

/**
 * @author zongqiang.hao
 */
public interface StreamSourcePlatformProvinceFirstplayDao {
    public List<StreamSourcePlatformProvinceFirstplay> getList(int sourceId, Date startDate, Date endDate);

    public List<StreamSourcePlatformProvinceFirstplay> getProvinceList(int sourceId, int platformId, String nowDate);

    public List<StreamSourcePlatformProvinceFirstplay> getAllList(String nowDate);
}
