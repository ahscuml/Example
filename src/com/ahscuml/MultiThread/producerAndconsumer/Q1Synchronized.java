package com.ahscuml.MultiThread.producerAndconsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ahscuml
 * @date 2019/4/14
 * @time 18:00
 */
public class Q1Synchronized {
    public static final int Max_LEN = 10;
    Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Q1Synchronized pc = new Q1Synchronized();
        // 内部类的初始化
        producer producer = pc.new producer();
        consumer consumer = pc.new consumer();
        Thread thread = new Thread(producer);
        thread.start();
        consumer.start();
    }

    // 只能继承thread然后调用start方法
    // 如果想要实现runnable接口，还要再新建线程
    class producer implements Runnable {
        @Override
        public void run() {
            producer();
        }

        private void producer() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == Max_LEN) {
                        // 通知阻塞的另外一个线程来继续操作
                        queue.notify();
                        System.out.println("达到队列最大容量");
                        try {
                            // 当前线程阻塞
                            queue.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(1);
                    queue.notify();
                    System.out.println("生产者生产一个任务");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class consumer extends Thread {
        @Override
        public void run() {
            consumer();
        }

        private void consumer() {
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        queue.notify();
                        System.out.println("队列为空");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    System.out.println("消费者消费一条任务");
                }
            }
        }
    }
}
