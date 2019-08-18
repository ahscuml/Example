package com.ahscuml.example.multithread.TheArtOfJava;

import java.util.concurrent.TimeUnit;

/**
 * @author ahscuml
 * @date 2019/2/25
 * @time 19:48
 */
public class join {
    public static void main(String[] args) throws Exception{
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(Thread.currentThread().getName() + "终止");
    }

    static class Domino implements Runnable {
        private Thread thread;
        // 构造函数
        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + "终止");
        }
    }
}


