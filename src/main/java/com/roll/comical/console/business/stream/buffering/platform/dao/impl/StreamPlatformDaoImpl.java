package com.roll.comical.console.business.stream.buffering.platform.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.roll.comical.console.business.stream.buffering.platform.PlatformBuffering;
import com.roll.comical.console.business.stream.buffering.platform.PlatformFirstplay;
import com.roll.comical.console.business.stream.buffering.platform.dao.StreamPlatformDao;

/**
 * @author zongqiang.hao
 */
@Repository
public class StreamPlatformDaoImpl implements StreamPlatformDao {

    @Resource(name = "jellyfishQosMasterSqlMapClientTemplate")
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Override
    public List<PlatformBuffering> getList(Date startDate, Date endDate) {
        Map<String, Object> params = new HashedMap();
        params.put("startDate", startDate);
        params.put("endDate", endDate);

        return sqlMapClientTemplate.queryForList("StreamPlatformBufferingDao.getList", params);
    }

    @Override
    public List<PlatformFirstplay> getFirstplayList(Date startDate, Date endDate) {
        Map<String, Object> params = new HashedMap();
        params.put("startDate", startDate);
        params.put("endDate", endDate);

        return sqlMapClientTemplate.queryForList("StreamPlatformFirstplayDao.getList", params);
    }
}
