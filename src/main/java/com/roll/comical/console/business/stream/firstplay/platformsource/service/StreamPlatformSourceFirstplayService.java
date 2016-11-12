package com.roll.comical.console.business.stream.firstplay.platformsource.service;

import java.util.Date;
import java.util.List;

import com.roll.comical.console.business.stream.firstplay.platformsource.PlatformSourceFirstplay;

/**
 * @author zongqiang.hao
 */
public interface StreamPlatformSourceFirstplayService {
    public List<PlatformSourceFirstplay> getList(int platformId, Date startDate, Date endDate);
}
