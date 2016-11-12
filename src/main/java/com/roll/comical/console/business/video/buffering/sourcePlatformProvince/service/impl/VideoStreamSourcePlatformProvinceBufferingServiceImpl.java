package com.roll.comical.console.business.video.buffering.sourcePlatformProvince.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roll.comical.console.business.video.buffering.sourcePlatformProvince.VideoSourcePlatformProvinceBuffering;
import com.roll.comical.console.business.video.buffering.sourcePlatformProvince.dao.VideoStreamSourcePlatformProvinceBufferingDao;
import com.roll.comical.console.business.video.buffering.sourcePlatformProvince.service.VideoStreamSourcePlatformProvinceBufferingService;

/**
 * @author zongqiang.hao
 */
@Service
public class VideoStreamSourcePlatformProvinceBufferingServiceImpl implements VideoStreamSourcePlatformProvinceBufferingService {
    @Autowired
    private VideoStreamSourcePlatformProvinceBufferingDao streamPlatformSourceBufferingDao;

    @Override
    public List<VideoSourcePlatformProvinceBuffering> getList(int sourceId, Date startDate, Date endDate) {
        return streamPlatformSourceBufferingDao.getList(sourceId, startDate, endDate);
    }

    @Override
    public List<VideoSourcePlatformProvinceBuffering> getProvinceList(int sourceId, int platformId, String nowDate) {
        return streamPlatformSourceBufferingDao.getProvinceList(sourceId, platformId, nowDate);
    }

    @Override
    public List<VideoSourcePlatformProvinceBuffering> getAllList(String nowDate) {
        return streamPlatformSourceBufferingDao.getAllList(nowDate);
    }
}
