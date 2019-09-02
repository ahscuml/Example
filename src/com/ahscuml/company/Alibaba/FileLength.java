package com.ahscuml.company.Alibaba;

import java.io.File;
import java.util.*;
import java.util.concurrent.CountDownLatch;


/**
 * 题目：按文件大小排序，统计一个目录下按文件大小从高到底排序的TOP20个文件。
 * 输入：一个目录，如/home/
 * 输出：按文件大小排序的TOP20个文件
 *
 * 先找出来所有的文件，然后对所有的文件进行排序，还是直接使用多线程，找文件顺带排序
 *
 * 找文件之后使用
 *
 * 1. 为什么要用多线程
 * 2. 堆排的思路是怎么样的
 * 3. 获取File 以及获取File的长度
 * */
public class FileLength {
    private static CountDownLatch latch;
    private static int capacity = 20;
    private static PriorityQueue<File> res = new PriorityQueue<>(capacity, new comparator());
    private static String sourcePath = "";
    private static int threadCount = Runtime.getRuntime().availableProcessors() * 2;
    private static List<File> fileList = new ArrayList<>();

    public static void main(String[] args) {
        if (!new File(sourcePath).exists()) {
            System.out.println("路径不存在");
            return;
        }

        // 获取所有的文件,存储到fileList中
        getFiles(sourcePath);

        // 多线程进行堆排，然后把每个线程筛选出来的20个file再进行堆排。
        if (fileList.size() < threadCount) {
            for (File file : fileList) {
                res.offer(file);
            }
        } else {
            int batch = fileList.size() / threadCount;
            int index = fileList.size();
            latch = new CountDownLatch(threadCount);
            for (int i = 0; i < threadCount; i++) {
                List<File> temp;
                if (i == threadCount - 1) {
                    temp = fileList.subList(i * batch, index);
                } else {
                    int start = i * batch, end = Math.min((i + 1) * batch, index + 1);
                    temp = fileList.subList(start, end);
                }
                Thread thread = new Thread(new MyThread(temp));
                thread.start();
            }
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 打印结果
        Stack<File> stack = new Stack<>();
        while (res.peek() != null) {
            stack.push(res.poll());
        }
        int i = 1;
        while (!stack.isEmpty()) {
            System.out.println(i + ". " + stack.peek().getName() + " : " + stack.pop().length());
            i++;
        }
    }

    // 获取所有的file
    public static void getFiles(String strPath) {
        File[] files = new File(strPath).listFiles();
        if (files == null) {
            return;
        }
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                getFiles(files[i].getPath());
            } else {
                fileList.add(files[i]);
            }
        }
    }

    // 两个file进行比较, 这个是小顶堆
    public static class comparator implements Comparator<File> {
        @Override
        public int compare(File f1, File f2) {
            if (f1.length() > f2.length()) {
                return 1;
            } else if (f1.length() < f2.length()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    // 进行排序的线程
    public static class MyThread implements Runnable {
        List<File> fileList;
        private PriorityQueue<File> topCapacity = new PriorityQueue<>(new comparator());


        MyThread(List<File> fileList) {
            this.fileList = fileList;
        }

        @Override
        public void run() {
            // 针对文件进行堆排
            for (File file : fileList) {
                if (topCapacity.size() >= capacity) {
                    if (topCapacity.peek().length() < file.length()) {
                        topCapacity.poll();
                        topCapacity.offer(file);
                    }
                } else {
                    topCapacity.offer(file);
                }
            }
            synchronized (res) {
                while (topCapacity.peek() != null) {
                    if (res.size() == capacity) {
                        if (topCapacity.peek().length() > res.peek().length()) {
                            res.poll();
                            res.offer(topCapacity.poll());
                        } else {
                            topCapacity.poll();
                        }
                    } else {
                        res.offer(topCapacity.poll());
                    }
                }
            }
            latch.countDown();
        }
    }
}
