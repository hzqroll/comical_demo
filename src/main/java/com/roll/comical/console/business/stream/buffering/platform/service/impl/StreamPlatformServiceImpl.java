package com.roll.comical.console.business.stream.buffering.platform.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roll.comical.console.business.stream.buffering.platform.PlatformBuffering;
import com.roll.comical.console.business.stream.buffering.platform.PlatformFirstplay;
import com.roll.comical.console.business.stream.buffering.platform.dao.StreamPlatformDao;
import com.roll.comical.console.business.stream.buffering.platform.service.StreamPlatformService;

/**
 * @author zongqiang.hao
 */

@Service
public class StreamPlatformServiceImpl implements StreamPlatformService {

    @Autowired
    private StreamPlatformDao streamPlatformDao;

    @Override
    public List<PlatformBuffering> getList(Date startDate, Date endDate) {
        return streamPlatformDao.getList(startDate, endDate);
    }

    @Override
    public List<PlatformFirstplay> getFirstplay(Date startDate, Date endDate) {
        return streamPlatformDao.getFirstplayList(startDate, endDate);
    }
}
