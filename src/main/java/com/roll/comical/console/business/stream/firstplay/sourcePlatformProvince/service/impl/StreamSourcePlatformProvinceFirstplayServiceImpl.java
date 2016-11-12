package com.roll.comical.console.business.stream.firstplay.sourcePlatformProvince.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roll.comical.console.business.stream.firstplay.sourcePlatformProvince.StreamSourcePlatformProvinceFirstplay;
import com.roll.comical.console.business.stream.firstplay.sourcePlatformProvince.dao.StreamSourcePlatformProvinceFirstplayDao;
import com.roll.comical.console.business.stream.firstplay.sourcePlatformProvince.service.StreamSourcePlatformProvinceFirstplayService;

/**
 * @author zongqiang.hao
 */
@Service
public class StreamSourcePlatformProvinceFirstplayServiceImpl implements StreamSourcePlatformProvinceFirstplayService {
    @Autowired
    private StreamSourcePlatformProvinceFirstplayDao streamPlatformSourceBufferingDao;

    @Override
    public List<StreamSourcePlatformProvinceFirstplay> getList(int sourceId, Date startDate, Date endDate) {
        return streamPlatformSourceBufferingDao.getList(sourceId, startDate, endDate);
    }

    @Override
    public List<StreamSourcePlatformProvinceFirstplay> getProvinceList(int sourceId, int platformId, String nowDate) {
        return streamPlatformSourceBufferingDao.getProvinceList(sourceId, platformId, nowDate);
    }

    @Override
    public List<StreamSourcePlatformProvinceFirstplay> getAllList(String nowDate) {
        return streamPlatformSourceBufferingDao.getAllList(nowDate);
    }
}
