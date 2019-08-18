package com.ahscuml.pattern.proxy.common;

/**
 * @author ahscuml
 * @date 2019/1/6
 * @time 10:22
 */
public class GamePlayerProxy implements IGamePlayer {
    private IGamePlayer gamePlayer = null;

    /**
     * 通过构造函数来传递要对谁进行代练
     * */
    public GamePlayerProxy(String name) {
        try {
            // 只能通过代理来创建对象
            gamePlayer = new GamePlayer(this, name);
        } catch (Exception e) {
            // TODO 异常处理
        }
    }

    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    @Override
    public void login(String user, String Password) {
        this.gamePlayer.login(user, Password);
    }

    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
    }
}
