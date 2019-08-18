package com.ahscuml.basic.callback;

/**
 * @author ahscuml
 * @date 2019/3/30
 * @time 11:14
 */
public class test {
    public static void main(String[] args) {
        Student xiaoming = new Student("xiaoming");
        Worker worker = new Worker("tiezhu");

        xiaoming.fillBlank(5, 6);
        worker.fillBlank(1, 2);
    }
}
