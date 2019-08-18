package com.ahscuml.pattern.proxy.force;

/**
 * @author ahscuml
 * @date 2019/1/6
 * @time 10:26
 */
public class Client {
    /**
     * 强制代理类，智能通过真实角色查找到代理角色
     * 高层模块new了一个真实角色，但是返回的却是一个代理角色
     */
    public static void main(String[] args) {
        // 创建游戏对象
        IGamePlayer player = new GamePlayer("真实用户");
        // 只能通过真实对象来找到代理对象
        IGamePlayer proxy = player.getProxy();
        System.out.println("开始时间是" + System.currentTimeMillis());
        // 代理登录
        proxy.login("真实用户", "password");
        proxy.killBoss();
        proxy.upgrade();
        System.out.println("结束时间是：" + System.currentTimeMillis());
    }
}
