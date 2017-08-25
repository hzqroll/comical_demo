package com.roll.comical.console.business.drivermanger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author zongqiang.hao
 */
public class DriverM {
    public static void main(String args[]) throws SQLException {

        List<HashMap<String,String>> columns = new ArrayList<HashMap<String,String>>();

        DriverManagerDataSource ds =  new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/comical");
        ds.setUsername("root");
        ds.setPassword("111111");
        Connection actualCon = ds.getConnection();

        /*String sql = "select * from user";

        Statement smt = actualCon.createStatement();
        ResultSet rs = smt.executeQuery(sql);
        while (rs.next()){
            HashMap<String,String> map = new HashMap<String,String>();
            map.put("id", rs.getString("id"));
            map.put("userName", rs.getString("userName"));
            map.put("userAge", rs.getString("userAge"));
            map.put("userAddress", rs.getString("userAddress"));
            columns.add(map);
        }*/


        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(ds);

        String sql = "create table t_user(user_id int NOT NULL,user_name varchar(60))";
        jdbcTemplate.execute(sql);

        //调用存储过程1
        String sql_p="{ call procedure}";
        Integer num = jdbcTemplate.execute(sql_p, new CallableStatementCallback<Integer>() {
            @Override
            public Integer doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.setInt(1,1);//绑定参数
                cs.registerOutParameter(2, Types.INTEGER);//注册输出参数
                cs.execute();
                return null;
            }
        });

        //调用存储过程2
        CallableStatementCreatorFactory fac = new CallableStatementCreatorFactory(sql_p);
        fac.addParameter(new SqlParameter("userId",Types.INTEGER));
        fac.addParameter(new SqlParameter("topicNum",Types.INTEGER));
        Map<String,Integer> paramsMap = new HashMap<String,Integer>();
        paramsMap.put("UserId",1);
        CallableStatementCreator csc = fac.newCallableStatementCreator(paramsMap);
        Integer num_2 = jdbcTemplate.execute(csc, new CallableStatementCallback<Integer>() {
            @Override
            public Integer doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.execute();
                return cs.getInt(2);
            }
        });
    }
}
