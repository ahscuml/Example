package com.ahscuml.company.Tencent;

import java.util.Scanner;

/**
 * @author ahscuml
 * @date 2019/3/10
 * @time 20:40
 */
public class Q4 {
    public static void main(String[] args) {



        // 最开始棋盘上的数值，坐标相加， 奇数是黑的，偶数是白的
        // 所以最开始的黑白很好数
        // 当第一次处理涂白的时候，也很好办
        // 第二次涂黑，需要考虑是否有重叠

        // 维护一个二维数组，作为棋盘，先初始化，白的是1，黑的是0
        // 涂白，就赋值1
        // 涂黑，就赋值0
        // 然后统计黑白数量

        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            for(int i = 0; i < n; i++) {
                int col = sc.nextInt();
                int row = sc.nextInt();

                int colW1 = sc.nextInt();
                int rowW1 = sc.nextInt();

                int colW2 = sc.nextInt();
                int rowW2 = sc.nextInt();

                int colB1 = sc.nextInt();
                int rowB1 = sc.nextInt();

                int colB2 = sc.nextInt();
                int rowB2 = sc.nextInt();

                int [][] matrix = new int[col][row];
                // 对棋盘进行初始化  白色是1，黑色是0
                for(int colTemp = 0; colTemp < col; colTemp++) {
                    for(int rowTemp = 0; rowTemp < row; rowTemp++) {
                        if((colTemp + rowTemp) % 2 == 0) {
                            matrix[colTemp][rowTemp] = 1;
                        }
                    }
                }

                // 先将棋盘涂白
                for(int colTemp = colW1 - 1; colTemp < colW2; colTemp++) {
                    for(int rowTemp = rowW1 - 1; rowTemp < rowW2; rowTemp++) {
                        matrix[colTemp][rowTemp] = 1;
                    }
                }

                // 再将棋盘涂黑
                for(int colTemp = colB1 - 1; colTemp < colB2; colTemp++) {
                    for(int rowTemp = rowB1 - 1; rowTemp < rowB2; rowTemp++) {
                        matrix[colTemp][rowTemp] = 0;
                    }
                }

                // 统计黑白数量
                int Black = 0;
                int White = 0;
                for(int colTemp = 0; colTemp < col; colTemp++) {
                    for(int rowTemp = 0; rowTemp < row; rowTemp++) {
                        if(matrix[colTemp][rowTemp] == 1) {
                            White++;
                        } else {
                            Black++;
                        }
                    }
                }
                System.out.println(White + " " + Black);
            }
        }
    }
}
