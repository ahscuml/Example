package com.ahscuml.MultiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ahscuml
 * @date 2019/4/14
 * @time 23:19
 */
public class test implements Callable<Integer> {
    public static void main(String[] args) {
        test test = new test();
        FutureTask<Integer> futureTask = new FutureTask<>(test);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println(futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
    }

    @Override
    public Integer call() {
        return 1;
    }
}
