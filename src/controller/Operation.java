package controller;

import model.GameData;
import view.ImgButton;
import view.MainWin;
import view.NewDialog;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
    public OpButton left;
    public OpButton right;
    public OpButton down;
    public OpButton rota;
    public ImgButton start;
    public ImgButton login;

    /**
     * 构造函数，在实例化ImgButton时给点击事件添加功能
     */
    public Operation(){
        left= new OpButton(new ImageIcon("img/left.png")) {
            @Override
            public void doClick() {
                //向左移动
                gameData.move(true,-1);
                //获取游戏区域在重画一次实现移动效果
                mainWin.getGamePanel().repaint();
            }
        };
        right= new OpButton(new ImageIcon("img/right.png")) {
            @Override
            public void doClick() {
                //向右移动
                gameData.move(true,1);
                //获取游戏区域在重画一次实现移动效果
                mainWin.getGamePanel().repaint();
            }
        };
        down= new OpButton(new ImageIcon("img/down.png")) {
            @Override
            public void doClick() {
                //向下移动
                if(gameData.move(false,1)){
                    mainWin.getScoreNext().repaint();
                }
                //获取游戏区域在重画一次实现移动效果
                mainWin.getGamePanel().repaint();
            }
        };
        rota= new OpButton(new ImageIcon("img/rota.png")) {
            @Override
            public void doClick() {
                //旋转
                gameData.rote();
                //获取游戏区域再重画一次实现旋转效果
                mainWin.getGamePanel().repaint();
            }
        };
        start= new ImgButton(new ImageIcon("img/start.png")) {
            @Override
            public void onClick() {
                if (gameData.status==1){
                    gameData.status=2;
                }else {
                    gameData.status = 1;
                }
            }
        };
        login= new ImgButton(new ImageIcon("img/login.png")) {
            @Override
            public void onClick() {
                new NewDialog(mainWin,gameData,NewDialog.LOGIN).openDialog();
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
        this.mainWin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    down.onClick();
                }else if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    left.onClick();
                }else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    right.onClick();
                }else if (e.getKeyCode() == KeyEvent.VK_UP){
                    rota.onClick();
                }
            }
        });
    }
    /**
     * 死亡和暂停时不可使用按键
     */
    abstract class OpButton extends ImgButton{
        /**
         * 创建对象时添加图片
         *
         * @param imageIcon
         */
        public OpButton(ImageIcon imageIcon) {
            super(imageIcon);
        }

        @Override
        public void onClick() {
            if (gameData.status==1){
                doClick();
            }
        }

        /**
         * 抽象点击方法
         */
        @Override
        abstract public void doClick();
    }
}
