package com.ahscuml.example.multithread.TheArtOfJava;

/**
 * @author ahscuml
 * @date 2019/2/25
 * @time 20:12
 */
public class NotifyTest {
    public static void main(String[] args) throws InterruptedException {
        final NotifyTest test = new NotifyTest();
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.testWait();
                }
            }).start();
        }

        Thread.sleep(3000);
        System.out.println("-----------分割线-------------");

        System.out.println("使用notify方法");
        // 同步方法块
        synchronized (test) {
            test.notify();
        }
        Thread.sleep(3000);
        System.out.println("-----------分割线-------------");

        System.out.println("使用notifyall方法");
        // 同步方法块
        synchronized (test) {
            test.notifyAll();
        }
    }

    /**
     * 同步方法
     */
    public synchronized void testWait() {
        System.out.println(Thread.currentThread().getName() + " Start-----");
        try {
            wait(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " End-------");
    }
}
