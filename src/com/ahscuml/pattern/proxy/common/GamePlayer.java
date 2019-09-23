package com.ahscuml.pattern.proxy.common;

/**
 * @author ahscuml
 * @date 2019/1/6
 * @time 10:12
 */
public class GamePlayer implements IGamePlayer {
    private String name;

    /**
     * 构造函数限制谁可以创建对象，并且同时创建姓名
     * 限制了只能拥有代理之后才能创建对象 IGamePlayer _gamePlayer
     */
    public GamePlayer(IGamePlayer _gamePlayer, String _name) throws Exception {
        if (_gamePlayer == null) {
            throw new Exception("不能创建真实角色");
        } else {
            this.name = _name;
        }
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
