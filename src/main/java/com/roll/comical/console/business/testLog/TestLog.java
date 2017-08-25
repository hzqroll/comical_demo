package com.roll.comical.console.business.testLog;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zongqiang.hao
 */
public class TestLog {
    private static final Logger LOG = LoggerFactory.getLogger(TestLog.class);
    public static void main(String args[]){
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(formatter.format(new Date()));
        }catch (Exception e){
            LOG.error("error:",e);
            LOG.info("11");
            LOG.info("error name:{}",LOG.getName());
        }finally{
            LOG.info("done name:{}",LOG.getName());
        }

    }
}
