package controller;

import model.GameData;
import view.MainWin;

/**
 * @author: Qin
 * @Date: 2020/11/29.
 */
public class AutoDown extends Thread{
    private GameData gameData;
    private MainWin mainWin;

    public AutoDown(GameData gameData,MainWin mainWin){
        this.gameData = gameData;
        this.mainWin = mainWin;
    }
    @Override
    public void run() {
        //循环下落
        while (true) {
            try {
                //调用移动方法
                gameData.move(false,1);
                mainWin.getGamePanel().repaint();
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
