package com.roll.comical.console.business.stream.buffering.platformsource.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.roll.comical.console.business.stream.buffering.platformsource.PlatformSourceBuffering;
import com.roll.comical.console.business.stream.buffering.platformsource.dao.StreamPlatformSourceBufferingDao;

/**
 * @author zongqiang.hao
 */
@Repository
public class StreamPlatformSourceBufferingDaoImpl implements StreamPlatformSourceBufferingDao {

    @Resource(name = "jellyfishQosMasterSqlMapClientTemplate")
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Override
    public List<PlatformSourceBuffering> getList(int platformId, Date startDate, Date endDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("platformId", platformId);
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        return sqlMapClientTemplate.queryForList("StreamPlatformSourceBufferingDao.getList", params);
    }
}
