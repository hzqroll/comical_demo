package com.roll.comical.console.business.stream.firstplay.platformsource.dao;

import java.util.Date;
import java.util.List;

import com.roll.comical.console.business.stream.firstplay.platformsource.PlatformSourceFirstplay;

/**
 * @author zongqiang.hao
 */
public interface StreamPlatformSourceFirstplayDao {
    public List<PlatformSourceFirstplay> getList(int platformId, Date startDate, Date endDate);
}
