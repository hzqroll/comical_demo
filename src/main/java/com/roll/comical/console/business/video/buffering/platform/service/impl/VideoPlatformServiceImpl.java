package com.roll.comical.console.business.video.buffering.platform.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roll.comical.console.business.video.buffering.platform.VideoPlatformBuffering;
import com.roll.comical.console.business.video.buffering.platform.dao.VideoPlatformDao;
import com.roll.comical.console.business.video.buffering.platform.service.VideoPlatformService;

/**
 * @author zongqiang.hao
 */

@Service
public class VideoPlatformServiceImpl implements VideoPlatformService {

    @Autowired
    private VideoPlatformDao streamPlatformDao;

    @Override
    public List<VideoPlatformBuffering> getList(Date startDate, Date endDate) {
        return streamPlatformDao.getList(startDate, endDate);
    }

}
