package com.roll.comical.console.business.stream.buffering.platformsource.dao;

import java.util.Date;
import java.util.List;

import com.roll.comical.console.business.stream.buffering.platformsource.PlatformSourceBuffering;

/**
 * @author zongqiang.hao
 */
public interface StreamPlatformSourceBufferingDao {
    public List<PlatformSourceBuffering> getList(int platformId, Date startDate, Date endDate);
}
