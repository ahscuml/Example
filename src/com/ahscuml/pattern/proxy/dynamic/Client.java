package com.ahscuml.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author ahscuml
 * @date 2019/1/5
 * @time 1:22
 */
public class Client {
    /**
     * 动态代理在实现阶段不关心代理谁，而在运行阶段才指定代理哪一个对象
     * AOP!!! 动态代理的另一个优势是面向切面编程，编程初期不用考虑融合的事情，在更高层级，通过动态代理，来将不同方便的内容融合在一起
     */
    public static void main(String[] args) {
        IGamePlayer player = new GamePlayer("真实用户");
        InvocationHandler handler = new GamePlayIH(player);
        // 最重要的方法， 返回一个指定接口的代理类实例，该接口可以将方法调用指派到指定的调用处理程序。
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(IGamePlayer.class.getClassLoader(), new
                Class[]{IGamePlayer.class}, handler);
        proxy.login("真实用户", "password");
        proxy.killBoss();
        proxy.upgrade();
    }
}
