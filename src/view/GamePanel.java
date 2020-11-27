package view;

import model.GameData;

import javax.swing.*;
import java.awt.*;

/**
 * @author: Qin
 * @Date: 2020/11/25.
 * 游戏画布
 */
public class GamePanel extends JPanel {
    private static final long serialVersionUID = 4L;
    GameData gameData;
    public GamePanel(GameData gameData) {
        //得到游戏数据
        this.gameData = gameData;
        //设置透明
        setOpaque(false);
        //画布大小位置
        setBounds(15,30,200,360);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //绘制方块
        g.fillRect(0,0,20,20);
    }
}
