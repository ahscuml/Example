package com.ahscuml.syn;

/**
 * @author ahscuml
 * @date 2019/3/24
 * @time 19:10
 */
public class MethodSync {

    /*
     * @Task : 测试 synchronized 修饰方法时锁定的是调用该方法的对象
     * @param name  线程的标记名称
     **/
    public synchronized void method(String name) {
        System.out.println(name + " Start a sync method");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
        }
        System.out.println(name + " End the sync method");
    }
}
