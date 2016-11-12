package com.roll.comical.console.business.stream.buffering.platformsource.service;

import java.util.Date;
import java.util.List;

import com.roll.comical.console.business.stream.buffering.platformsource.PlatformSourceBuffering;

/**
 * @author zongqiang.hao
 */
public interface StreamPlatformSourceBufferingService {
    public List<PlatformSourceBuffering> getList(int platformId, Date startDate, Date endDate);
}
