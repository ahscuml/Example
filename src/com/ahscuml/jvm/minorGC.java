package com.ahscuml.jvm;

/**
 * @author ahscuml
 * @date 2019/3/15
 * @time 8:47
 */
public class minorGC {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        testAlloction();
        System.gc();
    }

    public static void testAlloction() {
        byte[] alloction1, alloction2, alloction3, alloction4;
        alloction1 = new byte[2 * _1MB];
        alloction2 = new byte[2 * _1MB];
        alloction3 = new byte[2 * _1MB];
        alloction4 = new byte[4 * _1MB];
    }
}
