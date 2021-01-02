package view;

import controller.DataDao;
import model.GameData;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: Qin
 * @Date: 2021/1/2.
 */
public class Rank extends JPanel {
    private static final long serialVersionUID = 4L;
    GameData gameData;
    DataDao dataDao=new DataDao();

    public Rank(GameData gameData) {
        //得到游戏数据
        this.gameData = gameData;
        //设置透明
        setOpaque(false);
        //画布大小位置
        setBounds(15,405,200,130);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        List<User> data = getData();
        g.setFont(new Font("宋体",Font.BOLD, 23));
        //绘制分数
        g.drawString(data.get(0).getName()+"::"+data.get(0).getScore(), 10, 60);
        g.drawString(data.get(1).getName()+"::"+data.get(1).getScore(), 10, 90);
        g.drawString(data.get(2).getName()+"::"+data.get(2).getScore(), 10, 120);
    }
    public List<User> getData(){
        List<User> all = null;
        try {
            all = dataDao.findAll();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return all;
    }
}
