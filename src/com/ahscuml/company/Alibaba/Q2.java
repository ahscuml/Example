package com.ahscuml.company.Alibaba;

/**
 * 给一个txt文件，然后读出，判断这一行的末尾是不是大写，然后下一行的开头是不是大写，如果是大写，就将这个大写字母变成小写，然后
 * 再写入另外一个txt中
 * @author ahscuml
 * @date 2019/4/19
 * @time 14:45
 */
import java.io.*;
import java.lang.String;
public class Q2 {
    public static void main(String args[]) {
        // 读取数据
        String PATH = "D:\\Code\\Example\\text.txt";
        try {
            FileReader reader = new FileReader(PATH);
            BufferedReader br = new BufferedReader(reader);
            File writeName = new File("D:\\Code\\Example\\text1.txt");
            writeName.createNewFile();
            FileWriter writer = new FileWriter(writeName);
            BufferedWriter out = new BufferedWriter(writer);
            String A = "";
            String B = "";
            // 是否为空判断,初始化第一行
            if((A = br.readLine()) != null) {
                // B是新读入的，A是上一行的
                // 判断A的最后和B的开头是不是大写字符如果是改写B的开头写入TXT将A赋值为B，B再继续读
                while((B = br.readLine()) != null) {
                    // 判断最后一个字母是否是大写的
                    if(Character.isUpperCase(A.charAt(A.length() - 1))) {
                        if(Character.isUpperCase(B.charAt(0))) {
                            // 将B开头换成小写
                            B = Character.toLowerCase(B.charAt(0)) + B.substring(1);
                        }
                    }
                    // \b什么意思
                    out.write(A + "\r");
                    // 写入
                    A = B;
                }
                if(A != null && B == null) {
                    out.write(A);
                }
                out.flush();
            }
            br.close();
            out.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

