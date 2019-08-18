package com.ahscuml.pattern.proxy.dynamic;

/**
 * @author ahscuml
 * @date 2019/1/5
 * @time 1:19
 */
public interface IGamePlayer {
    public void login(String user, String password);

    public void killBoss();

    public void upgrade();
}
