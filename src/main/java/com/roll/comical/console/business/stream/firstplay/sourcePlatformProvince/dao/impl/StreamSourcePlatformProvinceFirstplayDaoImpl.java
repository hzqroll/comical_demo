package com.roll.comical.console.business.stream.firstplay.sourcePlatformProvince.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.roll.comical.console.business.stream.firstplay.sourcePlatformProvince.StreamSourcePlatformProvinceFirstplay;
import com.roll.comical.console.business.stream.firstplay.sourcePlatformProvince.dao.StreamSourcePlatformProvinceFirstplayDao;

/**
 * @author zongqiang.hao
 */
@Repository
public class StreamSourcePlatformProvinceFirstplayDaoImpl implements StreamSourcePlatformProvinceFirstplayDao {

    @Resource(name = "jellyfishQosMasterSqlMapClientTemplate")
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Override
    public List<StreamSourcePlatformProvinceFirstplay> getList(int sourceId, Date startDate, Date endDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("sourceId", sourceId);
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        return sqlMapClientTemplate.queryForList("StreamSourcePlatformProvinceFirstplayDao.getList", params);
    }

    @Override
    public List<StreamSourcePlatformProvinceFirstplay> getProvinceList(int sourceId, int platformId, String nowDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("sourceId", sourceId);
        params.put("platformId", platformId);
        params.put("nowDate", nowDate);
        return sqlMapClientTemplate.queryForList("StreamSourcePlatformProvinceFirstplayDao.getProvinceList", params);
    }

    @Override
    public List<StreamSourcePlatformProvinceFirstplay> getAllList(String nowDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("nowDate", nowDate);
        return sqlMapClientTemplate.queryForList("StreamSourcePlatformProvinceFirstplayDao.getAllList", params);
    }
}
