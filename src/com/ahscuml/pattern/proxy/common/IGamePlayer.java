package com.ahscuml.pattern.proxy.common;

/**
 * @author ahscuml
 * @date 2019/1/5
 * @time 1:19
 */
public interface IGamePlayer {
    void login(String user, String password);

    void killBoss();

    void upgrade();
}
