package controller;

import model.GameData;
import view.MainWin;
import view.NewDialog;

/**
 * 自动下落类，继承线程类实现休眠功能
 *
 * @author: Qin
 * @Date: 2020/11/29.
 */
public class AutoDown extends Thread {
    private GameData gameData;
    private MainWin mainWin;

    public AutoDown(GameData gameData, MainWin mainWin) {
        this.gameData = gameData;
        this.mainWin = mainWin;
    }

    /**
     * 重写run实现游戏边进行边下落
     */
    @Override
    public void run() {
        while (true) {
            try {
                if (gameData.status == 1) {
                    if (gameData.move(false, 1)) {
                        mainWin.getScoreNext().repaint();
                    }
                    mainWin.getGamePanel().repaint();
                    sleep(500);
                }else if (gameData.status==3){
                    gameData.init();
                    gameData.status=0;
                    mainWin.getRank().repaint();
                    mainWin.alert(NewDialog.OVER);
                } else {
                    sleep(150);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
