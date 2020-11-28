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
        setBounds(15, 30, 200, 360);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //遍历方块位置
        for (Point point : gameData.blocks.points) {
            //绘制实心方块
            g.fillRect((point.x + gameData.x) * 20, (point.y + gameData.y) * 20, 20, 20);
        }
    }
}
