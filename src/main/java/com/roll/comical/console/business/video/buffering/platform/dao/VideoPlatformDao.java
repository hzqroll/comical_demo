package com.roll.comical.console.business.video.buffering.platform.dao;

import java.util.Date;
import java.util.List;

import com.roll.comical.console.business.video.buffering.platform.VideoPlatformBuffering;

/**
 * @author zongqiang.hao
 */
public interface VideoPlatformDao {
    public List<VideoPlatformBuffering> getList(Date startDate, Date endDate);
}

