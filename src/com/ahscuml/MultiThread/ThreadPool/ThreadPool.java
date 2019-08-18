package com.ahscuml.MultiThread.ThreadPool;

import java.util.concurrent.*;

/**
 * @author ahscuml
 * @date 2019/3/28
 * @time 9:02
 */
public class ThreadPool {
    public static void main(String[] args) {
        // 创建线程池的四种方式
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService newSingleThreadPool = Executors.newSingleThreadExecutor();
        ExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(2);

        // 第五种
        ExecutorService threadpool = new ThreadPoolExecutor(1, 2, 100, TimeUnit.SECONDS, new ArrayBlockingQueue(10));

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个线程");
            }
        };
        threadpool.execute(task);
    }
}


