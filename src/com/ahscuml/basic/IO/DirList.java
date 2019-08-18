package com.ahscuml.basic.IO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 打印目录中的文件名
 *
 * @author ahscuml
 * @date 2019/4/22
 * @time 20:11
 */
public class DirList {
    public static void main(String[] args) {
        // 目录的路径
        File path = new File("D://Code//Example");
        // 存放名称的字符串数组
        String[] list;
        if (args.length == 0) {
            // 调用File对象的list方法
            list = path.list();
        } else {
            // 这个的args的意思是什么
            // 调用File对象的list有参函数，可以应用正则表达式匹配
            list = path.list(new DirFilter(args[0]));
        }
        // list可以排序
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        // 打印输出
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}

class DirFilter implements FilenameFilter {
    private Pattern pattern;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}