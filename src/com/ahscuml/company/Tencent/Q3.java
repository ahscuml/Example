package com.ahscuml.company.Tencent;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/3/10
 * @time 19:53
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int[] array = new int[n];
            for(int i = 0; i < n; i++) {
                array[i] = i + 1;
            }
            // System.out.println(array);
            // 记得输出的时候还要有空格
            int curIndex = 0;

            for(int i = 0; i < n; ) {
                // 如果当前的不为0，那么就扔掉(输出) 同时i+1;
                // 如果接下来的不为0，那么跳过
                // 也就是说，我需要找到两个不为0的内容，然后一个赋值为0，一个不处理

                // 输出的个数
                int num = 0;
                while (num < 2){
                    if(num == 0) {
                        if (array[curIndex] != 0) {
                            if(i == n - 1) {
                                System.out.print(array[curIndex]);
                            } else {
                                System.out.print(array[curIndex] + " ");
                            }
                            array[curIndex] = 0;
                            curIndex++;
                            i++;
                            if(i == n) {
                                break;
                            }
                            num++;
                        } else {
                            curIndex++;
                        }
                    } else {
                        if(array[curIndex] != 0) {
                            curIndex++;
                            num++;
                        } else {
                            curIndex++;
                        }
                    }
                    curIndex = curIndex % (n);
                }
            }
        }
    }
}
