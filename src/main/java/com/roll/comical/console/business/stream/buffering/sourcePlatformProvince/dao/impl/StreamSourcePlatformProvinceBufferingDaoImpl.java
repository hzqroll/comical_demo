package com.roll.comical.console.business.stream.buffering.sourcePlatformProvince.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.roll.comical.console.business.stream.buffering.sourcePlatformProvince.StreamSourcePlatformProvinceBuffering;
import com.roll.comical.console.business.stream.buffering.sourcePlatformProvince.dao.StreamSourcePlatformProvinceBufferingDao;

/**
 * @author zongqiang.hao
 */
@Repository
public class StreamSourcePlatformProvinceBufferingDaoImpl implements StreamSourcePlatformProvinceBufferingDao {

    @Resource(name = "jellyfishQosMasterSqlMapClientTemplate")
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Override
    public List<StreamSourcePlatformProvinceBuffering> getList(int sourceId, Date startDate, Date endDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("sourceId", sourceId);
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        return sqlMapClientTemplate.queryForList("StreamSourcePlatformProvinceBufferingDao.getList", params);
    }

    @Override
    public List<StreamSourcePlatformProvinceBuffering> getProvinceList(int sourceId, int platformId, String nowDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("sourceId", sourceId);
        params.put("platformId", platformId);
        params.put("nowDate", nowDate);
        return sqlMapClientTemplate.queryForList("StreamSourcePlatformProvinceBufferingDao.getProvinceList", params);
    }

    @Override
    public List<StreamSourcePlatformProvinceBuffering> getAllList(String nowDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("nowDate", nowDate);
        return sqlMapClientTemplate.queryForList("StreamSourcePlatformProvinceBufferingDao.getAllList", params);
    }
}
