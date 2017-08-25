package com.roll.comical.console.business.drivermanger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author zongqiang.hao
 */
public class ForumDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addForum(Forum forum){
        String sql="INSERT INTO t_forum(forum_name,forum_desc) VALUES(?,?)";
        Object[] params = (Object[]) new Object();
        jdbcTemplate.update(sql,new int[]{Types.VARCHAR,Types.VARCHAR});

    }

    public void addForums(final List<Forum> forums){
        final String sql = "";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int index) throws SQLException {
                Forum forum = forums.get(index);
                ps.setString(1,forum.getForum_name());
                ps.setString(2,forum.getFroum_desc());
            }

            @Override
            public int getBatchSize() {
                return forums.size();
            }
        });
    }

}
