package com.ahscuml.example.multithread;

/**
 * @author ahscuml
 * @date 2019/1/8
 * @time 22:57
 */
public class Test {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new thread());
        thread1.start();

    }
}


class thread implements Runnable {
    int count = 0;

    @Override
    public void run() {
        System.out.println(count);
    }
}