package com.ahscuml.pattern.proxy.force;

/**
 * @author ahscuml
 * @date 2019/1/6
 * @time 10:12
 */
public class GamePlayer implements IGamePlayer {
    private String name = "";
    private IGamePlayer proxy = null;

    public GamePlayer(String _name) {
        this.name = _name;
    }

    /**
     * 在真实对象里创建代理对象
     */
    @Override
    public IGamePlayer getProxy() {
        this.proxy = new GamePlayerProxy(this);
        return this.proxy;
    }

    @Override
    public void killBoss() {
        if (this.isProxy()) {
            System.out.println(this.name + "在打怪");
        } else {
            System.out.println("请使用指定代理");
        }
    }

    @Override
    public void login(String user, String Password) {
        if (this.isProxy()) {
            System.out.println("登录名为:" + user + "的用户" + this.name + "登录成功！");
        } else {
            System.out.println("请使用指定代理");
        }
    }

    @Override
    public void upgrade() {
        if (this.isProxy()) {
            System.out.println(this.name + "又升了一级");
        } else {
            System.out.println("请使用指定代理");
        }
    }

    private boolean isProxy() {
        if (this.proxy == null) {
            return false;
        } else {
            return true;
        }
    }
}
