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

    /**
     * 绘制
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        //遍历方块位置
        for (Point point : gameData.blocks.points) {
            //绘制实心方块
            //出现位置*单个像素大小
            g.setColor(gameData.colors[GameData.current]);
            g.fillRect((point.x + gameData.x) * 20, (point.y + gameData.y) * 20, 20, 20);
            g.drawImage(new ImageIcon("img/mask0.png").getImage(),(point.x + gameData.x) * 20, (point.y + gameData.y) * 20, 20, 20,null);
        }
        //绘制存在的方块
        int heightMax=19;
        int heightMin=2;
        int widthMax=10;
        //遍历每一个存在的格子
        for (int i = heightMax; i >=heightMin ; i--) {
            for (int j = 0; j < widthMax;j++){
                if (gameData.exist[j][i]!=0){
                    g.setColor(gameData.colors[gameData.exist[j][i]-1]);
                    g.fillRect(j*20,(i-2) * 20,20,20);
                    g.drawImage(new ImageIcon("img/mask0.png").getImage(),j*20,(i-2) * 20,20,20,null);
                }
            }
        }

    }
}
