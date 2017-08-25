package com.roll.comical.console.business.builder;

/**
 * @author zongqiang.hao
 */
public class PrintName {
    public void print(){
        final StackTraceElement a = Thread.currentThread().getStackTrace()[1];
        final StackTraceElement a1 = Thread.currentThread().getStackTrace()[2];
        System.out.println(a.getMethodName());
        System.out.println(a1.getMethodName());
        System.out.println(a1.getClassName());
    }
}
