package controller;

import model.GameData;
import model.User;
import view.MainWin;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: Qin
 * @Date: 2020/11/24.
 * 窗体控制类
 */
public class Main {
    public static void main(String[] args) {
        //实例化数据
        GameData gameData = new GameData();
        //实例化操作
        Operation op = new Operation();
        //实例化窗体对象,将数据和操作传递到窗体类
        MainWin mainWin = new MainWin(op,gameData);
        //将窗口与操作类关联
        op.setMainWin(mainWin);
        //将数据与操作区关联
        op.setGameData(gameData);
        //实现方块自动下落功能
        AutoDown autoDown = new AutoDown(gameData,mainWin);
        //启动下落
        autoDown.start();
        //使窗体一直显示
        mainWin.setVisible(true);
        DataDao dao=new DataDao();
        try {
            List<User> all = dao.findAll();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
