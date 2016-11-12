package com.roll.comical.console.business.video.buffering.platform.service;

import java.util.Date;
import java.util.List;

import com.roll.comical.console.business.video.buffering.platform.VideoPlatformBuffering;

/**
 * @author zongqiang.hao
 */
public interface VideoPlatformService {

    public List<VideoPlatformBuffering> getList(Date startDate, Date endDate);
}
