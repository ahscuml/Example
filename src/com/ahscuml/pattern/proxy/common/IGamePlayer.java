package com.ahscuml.pattern.proxy.common;

/**
 * @author ahscuml
 * @date 2019/1/5
 * @time 1:19
 */
public interface IGamePlayer {
    /**
     * 登录
     *
     * @param user 用户名
     * @param password 密码
     * */
    void login(String user, String password);

    /**
     * 打倒Boss
     * */
    void killBoss();

    /**
     * 升级
     * */
    void upgrade();
}
