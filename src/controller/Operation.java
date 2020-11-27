package controller;

import model.GameData;
import view.MainWin;

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
