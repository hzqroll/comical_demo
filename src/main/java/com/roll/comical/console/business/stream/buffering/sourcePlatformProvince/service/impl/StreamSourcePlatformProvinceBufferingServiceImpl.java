package com.roll.comical.console.business.stream.buffering.sourcePlatformProvince.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roll.comical.console.business.stream.buffering.sourcePlatformProvince.StreamSourcePlatformProvinceBuffering;
import com.roll.comical.console.business.stream.buffering.sourcePlatformProvince.dao.StreamSourcePlatformProvinceBufferingDao;
import com.roll.comical.console.business.stream.buffering.sourcePlatformProvince.service.StreamSourcePlatformProvinceBufferingService;

/**
 * @author zongqiang.hao
 */
@Service
public class StreamSourcePlatformProvinceBufferingServiceImpl implements StreamSourcePlatformProvinceBufferingService {
    @Autowired
    private StreamSourcePlatformProvinceBufferingDao streamPlatformSourceBufferingDao;

    @Override
    public List<StreamSourcePlatformProvinceBuffering> getList(int sourceId, Date startDate, Date endDate) {
        return streamPlatformSourceBufferingDao.getList(sourceId, startDate, endDate);
    }

    @Override
    public List<StreamSourcePlatformProvinceBuffering> getProvinceList(int sourceId, int platformId, String nowDate) {
        return streamPlatformSourceBufferingDao.getProvinceList(sourceId, platformId, nowDate);
    }

    @Override
    public List<StreamSourcePlatformProvinceBuffering> getAllList(String nowDate) {
        return streamPlatformSourceBufferingDao.getAllList(nowDate);
    }
}
