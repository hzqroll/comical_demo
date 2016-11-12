package com.roll.comical.console.business.stream.buffering.platform.dao;

import java.util.Date;
import java.util.List;

import com.roll.comical.console.business.stream.buffering.platform.PlatformBuffering;
import com.roll.comical.console.business.stream.buffering.platform.PlatformFirstplay;

/**
 * @author zongqiang.hao
 */
public interface StreamPlatformDao {
    public List<PlatformBuffering> getList(Date startDate, Date endDate);

    public List<PlatformFirstplay> getFirstplayList(Date startDate, Date endDate);
}

