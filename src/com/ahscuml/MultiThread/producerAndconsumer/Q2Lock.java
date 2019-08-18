package com.ahscuml.MultiThread.producerAndconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ahscuml
 * @date 2019/4/14
 * @time 20:58
 */
public class Q2Lock {
    private final int MAX_LEN = 10;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] args) {
        Q2Lock pc = new Q2Lock();
        Producer producer = pc.new Producer();
        Consumer consumer = pc.new Consumer();
        producer.start();
        consumer.start();
    }

    class Producer extends Thread {
        @Override
        public void run() {
            producer();
        }

        private void producer() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == MAX_LEN) {
                        System.out.println("当前队列满");
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(1);
                    condition.signal();
                    System.out.println("生产者生产一个线程");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            consumer();
        }

        private void consumer() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        System.out.println("队列为空");
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    condition.signal();
                    System.out.println("消费者消费了一条任务");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
