package com.roll.comical.console.business.singleton;

/**
 * @author zongqiang.hao
 */
public class Elvis {

    private Elvis() {
    }

    private static class SingletonHolder {
        private static final Elvis INSTANCE = new Elvis();
    }

    public static Elvis getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
