package com.roll.comical.console.business.video.buffering.platform.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.roll.comical.console.business.video.buffering.platform.VideoPlatformBuffering;
import com.roll.comical.console.business.video.buffering.platform.dao.VideoPlatformDao;

/**
 * @author zongqiang.hao
 */
@Repository
public class VideoPlatformDaoImpl implements VideoPlatformDao {

    @Resource(name = "jellyfishQosMasterSqlMapClientTemplate")
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Override
    public List<VideoPlatformBuffering> getList(Date startDate, Date endDate) {
        Map<String, Object> params = new HashedMap();
        params.put("startDate", startDate);
        params.put("endDate", endDate);

        return sqlMapClientTemplate.queryForList("VideoPlatformBufferingDao.getList", params);
    }

}
