package com.roll.comical.console.business.stream.firstplay.platformsource.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roll.comical.console.business.stream.firstplay.platformsource.PlatformSourceFirstplay;
import com.roll.comical.console.business.stream.firstplay.platformsource.dao.StreamPlatformSourceFirstplayDao;
import com.roll.comical.console.business.stream.firstplay.platformsource.service.StreamPlatformSourceFirstplayService;

/**
 * @author zongqiang.hao
 */
@Service
public class StreamPlatformSourceFirstplayServiceImpl implements StreamPlatformSourceFirstplayService {
    @Autowired
    private StreamPlatformSourceFirstplayDao streamPlatformSourceFirstplayDao;

    @Override
    public List<PlatformSourceFirstplay> getList(int platformId, Date startDate, Date endDate) {
        return streamPlatformSourceFirstplayDao.getList(platformId, startDate, endDate);
    }
}
