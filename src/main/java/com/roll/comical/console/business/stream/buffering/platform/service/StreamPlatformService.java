package com.roll.comical.console.business.stream.buffering.platform.service;

import java.util.Date;
import java.util.List;

import com.roll.comical.console.business.stream.buffering.platform.PlatformBuffering;
import com.roll.comical.console.business.stream.buffering.platform.PlatformFirstplay;

/**
 * @author zongqiang.hao
 */
public interface StreamPlatformService {

    public List<PlatformBuffering> getList(Date startDate, Date endDate);

    public List<PlatformFirstplay> getFirstplay(Date startDate, Date endDate);
}
