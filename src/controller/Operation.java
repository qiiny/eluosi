package controller;

import model.GameData;
import view.ImgButton;
import view.MainWin;

import javax.swing.*;

/**
 * @author: Qin
 * @Date: 2020/11/27.
 * 操作类
 */
public class Operation {
    /**
     * 游戏数据与窗体
     */
    GameData gameData;
    MainWin mainWin;
    /**
     * 按钮对象
     */
    public ImgButton left;
    public ImgButton right;
    public ImgButton down;
    public ImgButton rota;
    public ImgButton start;
    public ImgButton setting;
    public ImgButton login;

    /**
     * 构造函数，在实例化ImgButton时给点击事件添加功能
     */
    public Operation(){
        left= new ImgButton(new ImageIcon("img/left.png")) {
            @Override
            public void onClick() {
                //向左移动
                gameData.move(true,-1);
                //获取游戏区域在重画一次实现移动效果
                mainWin.getGamePanel().repaint();
            }
        };
        right= new ImgButton(new ImageIcon("img/right.png")) {
            @Override
            public void onClick() {
                //向右移动
                gameData.move(true,1);
                //获取游戏区域在重画一次实现移动效果
                mainWin.getGamePanel().repaint();
            }
        };
        down= new ImgButton(new ImageIcon("img/down.png")) {
            @Override
            public void onClick() {
                //向右移动
                gameData.move(false,1);
                //获取游戏区域在重画一次实现移动效果
                mainWin.getGamePanel().repaint();
            }
        };
        rota= new ImgButton(new ImageIcon("img/rota.png")) {
            @Override
            public void onClick() {

            }
        };
        start= new ImgButton(new ImageIcon("img/start.png")) {
            @Override
            public void onClick() {

            }
        };
        setting= new ImgButton(new ImageIcon("img/setting.png")) {
            @Override
            public void onClick() {

            }
        };
        login= new ImgButton(new ImageIcon("img/login.png")) {
            @Override
            public void onClick() {

            }
        };
    }
    /**
     * 关联数据
     * @param gameData 游戏数据
     */
    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }
    /**
     * 关联视图
     * @param mainWin 游戏显示窗体
     */
    public void setMainWin(MainWin mainWin) {
        this.mainWin = mainWin;
    }
}
