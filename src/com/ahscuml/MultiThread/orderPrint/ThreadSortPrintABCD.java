package com.ahscuml.MultiThread.orderPrint;

/**
 * @author ahscuml
 * @date 2019/4/15
 * @time 15:44
 */

public class ThreadSortPrintABCD implements Runnable {
    private static int newIndex = 0;
    private static int runIndex = 0;
    private int id;
    private boolean isFirstRun;
    private String name;
    private Object self;
    private Object next;


    private ThreadSortPrintABCD(String name, Object self, Object next) {
        id = newIndex++;
        this.name = name;
        this.self = self;
        this.next = next;
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Object d = new Object();
        ThreadSortPrintABCD pa = new ThreadSortPrintABCD("A", a, b);
        ThreadSortPrintABCD pb = new ThreadSortPrintABCD("B", b, c);
        ThreadSortPrintABCD pc = new ThreadSortPrintABCD("C", c, d);
        ThreadSortPrintABCD pd = new ThreadSortPrintABCD("D", d, a);

        new Thread(pd).start();
        new Thread(pa).start();
        new Thread(pb).start();
        new Thread(pc).start();

    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (self) {
                // 上面这一部分是为了确保第一次输出的时候输出的是A
                // 不该自己输出，就自己wait,也就是确保第一个输出的是A
                if (id > runIndex) {
                    try {
                        self.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(name);
                /*if (!isFirstRun) {
                    runIndex++;
                    isFirstRun = true;
                }*/
                // 当前输出到第几个了，主要还是为了确保第一次输出的时候先从a开始输出
                runIndex++;

                // ----------------------------------------------------------------------------------

                count--;
                synchronized (next) {
                    next.notify();
                }
                if (count > 0) {
                    try {
                        self.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
