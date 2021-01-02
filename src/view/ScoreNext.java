package view;

import model.GameData;

import javax.swing.*;
import java.awt.*;
/**
 * 分数和下一个
 *
 * @author: Qin
 * @Date: 2021/1/1.
 */
public class ScoreNext extends JPanel {
    private static final long serialVersionUID = 4L;
    GameData gameData;
    /**
     * 对提示区偏移的进行补偿
     */
    int[] offset = new int[]{0, -10, 0, 0, -10, 0, 0};

    public ScoreNext(GameData gameData) {
        //得到游戏数据
        this.gameData = gameData;
        //设置透明
        setOpaque(false);
        //画布大小位置
        setBounds(240, 30, 90, 215);
    }

    /**
     * 绘制
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        g.setFont(new Font("黑体",Font.PLAIN, 23));
        //绘制分数
        g.drawString(gameData.getScore(), 10, 60);
        //提示区
        for (Point point : GameData.BLOCKS[gameData.next].points) {
            //绘制实心方块
            //出现位置*单个像素大小
            g.setColor(gameData.colors[gameData.next]);
            g.fillRect((point.x) * 20 + 35 + offset[gameData.next], (point.y) * 20 + 150, 20, 20);
            g.drawImage(new ImageIcon("img/mask0.png").getImage(), (point.x) * 20 + 35 + offset[gameData.next], (point.y) * 20 + 150, 20, 20, null);
        }
    }
}
