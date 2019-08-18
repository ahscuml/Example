package com.ahscuml.syn;

/**
 * 类锁和对象锁不同，他们之间不会产生互斥。
 *
 * @author ahscuml
 * @date 2019/3/24
 * @time 19:20
 */
public class SynchoronizedDemo {

    //synchronized修饰静态方法
    public static synchronized void staticFunction()
            throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println("Static function running...");
        }
    }

    public static void main(String[] args) {
        final SynchoronizedDemo demo = new SynchoronizedDemo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    staticFunction();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    demo.function();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }

    //synchronized修饰非静态方法
    public synchronized void function() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println("function running...");
        }
    }
}
