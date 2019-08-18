package com.ahscuml.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ahscuml
 * @date 2019/1/5
 * @time 1:24
 */

/**
 * 产生一个对象的代理对象
 */
public class GamePlayIH implements InvocationHandler {
    /**
     * 被代理者
     */
    Class cls = null;

    /**
     * 被代理实例
     */
    Object obj = null;

    /**
     * 构造函数:我要代理谁
     */
    public GamePlayIH(Object _obj) {
        this.obj = _obj;
    }

    /**
     * 调用被代理的方法
     * 所以可以有不同的代理，继承自InvocationHandler,完成不同的代理任务
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        Object result = method.invoke(this.obj, args);
        if (method.getName().equalsIgnoreCase("login")) {
            System.out.println("有人在用我的账号登录");
        }
        return result;
    }
}
