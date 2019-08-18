package com.ahscuml.basic;

/**
 * equals 和 == 之间的区别
 *
 * @author ahscuml
 * @date 2019/3/4
 * @time 22:21
 */
public class EqualsAnd {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        equalMark();
        equalsTest();
        method();
        Main.test();
    }

    public static void equalMark() {
        //《Java编程思想》：“关系操作符生成的是一个boolean结果，它们计算的是操作数的值之间的关系
        // 在Java中游8种基本数据类型：
        // 浮点型：float(4 byte), double(8 byte)
        //　整型：byte(1 byte), short(2 byte), int(4 byte) , long(8 byte)
        //　字符型: char(2 byte)
        // 布尔型: boolean(JVM规范没有明确规定其所占的空间大小，仅规定其只能够取字面值"true"和"false")
        // 比较过程分为基本类型与非基本数据类型

        // 比较两个基本类型的变量,值相同就相同
        int n = 3;
        int m = 3;
        System.out.println("基本数据类型: " + (n == m));

        // 比较两个非基本类型变量
        String str = new String("hello");
        String str1 = new String("hello");
        String str2 = new String("hello");
        // 不是同一个引用
        System.out.println("不是同一个引用: " + (str1 == str2));
        // 是同一个引用
        str1 = str;
        str2 = str;
        System.out.println("是同一个引用: " + (str1 == str2));
        // 输出结果为：true。原因很简单，"hello"+2在编译期间就已经被优化成"hello2"，因此在运行期间，变量a和变量b指向的是同一个对象。
        // 对于被final修饰的变量，会在class文件常量池中保存一个副本，也就是说不会通过连接而进行访问，对final变量的访问在编译期间都会直接被替代为真实的值。
        String a = "hello2";
        String b = "hello" + 2;
        System.out.println("没有显式初始化： " + (a == b));
        // 如果输出不一样，证明不是同一个对象呀，问题出在哪里
        a = a + 'b';
        System.out.println(a);
        System.out.println(b);
    }

    public static void equalsTest() {
        // equals方法是基类Object中的方法，因此对于所有的继承于Object的类都会有该方法。
        /*
        equals的底层实现
        public boolean equals(Object object) {
            return(this == object);
        }*/

        /**
         * 　　1）对于==，如果作用于基本数据类型的变量，则直接比较其存储的 “值”是否相等；
         * 　　　　如果作用于引用类型的变量，则比较的是所指向的对象的地址
         * 　　2）对于equals方法，注意：equals方法不能作用于基本数据类型的变量
         * 　　　　如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；
         * 　　　　诸如String、Date等类对equals方法进行了重写的话，比较的是所指向的对象的内容。
         * */

        String s1 = new String("aa");
        String s2 = new String("aa");
        System.out.println("不同对象值的比较: " + s1.equals(s2));
    }

    /**
     * 针对包装对象的类型隐藏
     * */
    public static void method() {
        Integer i1 = 100;
        Integer i2 = 100;

        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
    }

    /**
     * 通过方法调用返回的对象
     * */
    public static class Main {
        public static void test() {
            String a = "hello2";
            final String b = getHello();
            String c = b + 2;
            System.out.println((a == c));
        }

        public static String getHello() {
            return "hello";
        }
    }
}
