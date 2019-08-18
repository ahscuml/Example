package com.ahscuml.MultiThread.orderPrint;

/**
 * @author ahscuml
 * @date 2019/4/9
 * @time 23:07
 */

/*
 * *     如何指定多个线程的执行顺序:
 *     题目：
 *     		面试官会给你举个例子，如何让10个线程按照顺序打印0123456789
 *     1、设置一个锁对象
 * */

public class LockObject {
    final static int MAX_VALUE = 9;
    int orderNum;

    public LockObject(int orderNum) {
        this.orderNum = orderNum;
    }
}
