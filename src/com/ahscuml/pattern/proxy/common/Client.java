package com.ahscuml.pattern.proxy.common;

/**
 * @author ahscuml
 * @date 2019/1/6
 * @time 10:26
 */
public class Client {
    /**
     * 普通代理类，要知道代理的存在然后才能访问
     * 调用者只知代理而不用知道真实角色是谁，屏蔽了真实角色的改变对高层模块的影响。
     * */
    public static void main(String[] args) {
        // 只能创建代理的对象
        IGamePlayer proxy = new GamePlayerProxy("代练");
        System.out.println("开始时间是" + System.currentTimeMillis());
        // 代理登录
        proxy.login("真实用户", "password");
        proxy.killBoss();
        proxy.upgrade();
        System.out.println("结束时间是：" + System.currentTimeMillis());
    }
}
