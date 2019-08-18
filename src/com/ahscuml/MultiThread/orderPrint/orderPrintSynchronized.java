package com.ahscuml.MultiThread.orderPrint;

/**
 * 打印1到10的想法
 * 使用synchronized关键字，确保每一次只有一个线程可以获得锁，然后执行方法。
 * @author ahscuml
 * @date 2019/4/9
 * @time 23:02
 */
public class orderPrintSynchronized {
    private static Object lock = new Object();

    private static int i = 1;

    public static void main(String[] args) {
        orderPrintSynchronized o = new orderPrintSynchronized();
        Thread[] threads = new thread[10];
        for (int j = 0; j < 10; j++) {
            threads[i] = o.new thread();
            threads[i].start();
        }
    }

    class thread extends Thread {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(i);
                i++;
            }
        }
    }
}