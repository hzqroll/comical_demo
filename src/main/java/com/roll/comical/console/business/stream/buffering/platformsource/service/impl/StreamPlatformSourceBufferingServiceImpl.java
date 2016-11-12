package com.roll.comical.console.business.stream.buffering.platformsource.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roll.comical.console.business.stream.buffering.platformsource.PlatformSourceBuffering;
import com.roll.comical.console.business.stream.buffering.platformsource.dao.StreamPlatformSourceBufferingDao;
import com.roll.comical.console.business.stream.buffering.platformsource.service.StreamPlatformSourceBufferingService;

/**
 * @author zongqiang.hao
 */
@Service
public class StreamPlatformSourceBufferingServiceImpl implements StreamPlatformSourceBufferingService {
    @Autowired
    private StreamPlatformSourceBufferingDao streamPlatformSourceBufferingDao;

    @Override
    public List<PlatformSourceBuffering> getList(int platformId, Date startDate, Date endDate) {
        return streamPlatformSourceBufferingDao.getList(platformId, startDate, endDate);
    }
}
