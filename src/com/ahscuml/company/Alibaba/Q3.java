package com.ahscuml.company.Alibaba;

/**
 * 使三个线程打印从1到3
 * @author ahscuml
 * @date 2019/8/30
 * @time 1:20
 */
public class Q3 {
    public static void main(String[] args) {
        Object o = new Object();
        new Thread(new PrintNum(1, o)).start();
        new Thread(new PrintNum(2, o)).start();
        new Thread(new PrintNum(3, o)).start();
    }
}

class PrintNum implements Runnable {
    private static volatile int num = 1;
    private int threadId;
    private Object object;

    PrintNum(int threadId, Object object) {
        this.threadId = threadId;
        this.object = object;
    }

    @Override
    public void run() {
        while (num <= 3) {
            synchronized (object){
                if (this.threadId == num) {
                    System.out.println(num++);
                    object.notifyAll();
                } else {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}