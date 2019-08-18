package com.ahscuml.pattern.proxy.dynamic;

/**
 * @author ahscuml
 * @date 2019/1/6
 * @time 10:12
 */
public class GamePlayer implements IGamePlayer {
    private String name = "";

    public GamePlayer(String _name) {
        this.name = _name;
    }
    @Override
    public void killBoss() {
        System.out.println(this.name + "在打怪");
    }

    @Override
    public void login(String user, String Password) {
        System.out.println("登录名为:" + user + "的用户" + this.name + "登录成功！");
    }

    @Override
    public void upgrade() {
        System.out.println(this.name + "又升了一级");
    }
}
