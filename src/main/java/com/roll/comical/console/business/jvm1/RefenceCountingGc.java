package com.roll.comical.console.business.jvm1;

public class RefenceCountingGc {
    public Object instance = null;
    private static final int MX = 1024 * 1024;
    private byte[] bigsize = new byte[2 * MX];

    public static void main(String[] args) {
        RefenceCountingGc a = new RefenceCountingGc();
        RefenceCountingGc b = new RefenceCountingGc();

        a.instance = b;
        b.instance = a;

        a = null;
        b = null;
        System.gc();
    }
}
