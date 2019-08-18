package com.ahscuml.util;

import java.lang.reflect.Method;

/**
 * 生成测试用的数组
 *
 * @author ahscuml
 * @date 2019/3/12
 * @time 20:32
 */
public class sortTestHelper {

    /**
     * 生成一个随机的数组
     */
    public static int[] generateRandom(int n, int rangeL, int rangeR) {
        assert rangeL < rangeR : "输入错误";
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return num;
    }

    /**
     * 先生成一个有序的数组，然后再随机交换几个元素
     *
     * @param n         数组范围 0 - n
     * @param swapTimes 交换的次数
     */
    public static int[] genetateNearlySorted(int n, int swapTimes) {
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = i;
        }
        for (int i = 0; i < swapTimes; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            int temp = num[a];
            num[a] = num[b];
            num[b] = temp;
        }
        return num;
    }

    /**
     * 通过反射的方法测试排序需要的时间
     */
    public static void testSort(String sortClassName, String methodName, int[] num) {
        try {
            // 获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过Class对象获取排序方法
            Method sortMethod = sortClass.getMethod(methodName, int[].class);

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null, num);
            long endTime = System.currentTimeMillis();

            // 判断是否已经有序  注意assert要自己在jvm中设置才开启
            assert isSorted(num);

            System.out.println(methodName + " : " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断是否排序
     */
    public static boolean isSorted(int[] num) {
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] > num[i + 1]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 打印数组
     */
    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
        return;
    }
}
