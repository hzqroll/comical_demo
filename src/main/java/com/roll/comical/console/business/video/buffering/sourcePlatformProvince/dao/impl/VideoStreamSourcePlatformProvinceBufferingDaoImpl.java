package com.roll.comical.console.business.video.buffering.sourcePlatformProvince.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.roll.comical.console.business.video.buffering.sourcePlatformProvince.VideoSourcePlatformProvinceBuffering;
import com.roll.comical.console.business.video.buffering.sourcePlatformProvince.dao.VideoStreamSourcePlatformProvinceBufferingDao;

/**
 * @author zongqiang.hao
 */
@Repository
public class VideoStreamSourcePlatformProvinceBufferingDaoImpl implements VideoStreamSourcePlatformProvinceBufferingDao {

    @Resource(name = "jellyfishQosMasterSqlMapClientTemplate")
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Override
    public List<VideoSourcePlatformProvinceBuffering> getList(int sourceId, Date startDate, Date endDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("sourceId", sourceId);
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        return sqlMapClientTemplate.queryForList("VideoSourcePlatformProvinceBufferingDao.getList", params);
    }

    @Override
    public List<VideoSourcePlatformProvinceBuffering> getProvinceList(int sourceId, int platformId, String nowDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("sourceId", sourceId);
        params.put("platformId", platformId);
        params.put("nowDate", nowDate);
        return sqlMapClientTemplate.queryForList("VideoSourcePlatformProvinceBufferingDao.getProvinceList", params);
    }

    @Override
    public List<VideoSourcePlatformProvinceBuffering> getAllList(String nowDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("nowDate", nowDate);
        return sqlMapClientTemplate.queryForList("VideoSourcePlatformProvinceBufferingDao.getAllList", params);
    }
}
