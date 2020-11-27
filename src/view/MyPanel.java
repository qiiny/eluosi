package view;

import javax.swing.*;
import java.awt.*;

/**
 * @author: Qin
 * @Date: 2020/11/24.
 * 继承绘图容器
 */
public class MyPanel extends JPanel {
    private static final long serialVersionUID=2L;

    public MyPanel() {
        //设置大小，同窗体一样大
        setBounds(0,0,360,600);
        //设置画布为自由布局
        setLayout(null);
        //取消背景颜色
        setOpaque(false);
        //设置按钮并且添加图片
        //左移
        JButton left=new ImgButton(new ImageIcon("img/left.png"));
        //右移
        JButton right=new ImgButton(new ImageIcon("img/right.png"));
        //下滑
        JButton down=new ImgButton(new ImageIcon("img/down.png"));
        //旋转
        JButton rota=new ImgButton(new ImageIcon("img/rota.png"));
        //开始
        JButton start=new ImgButton(new ImageIcon("img/start.png"));
        //设置
        JButton setting=new ImgButton(new ImageIcon("img/setting.png"));
        //登录
        JButton login=new ImgButton(new ImageIcon("img/login.png"));
        //按钮位置
        left.setBounds(240,255,45,45);
        right.setBounds(285,255,45,45);
        down.setBounds(240,300,45,45);
        rota.setBounds(285,300,45,45);
        start.setBounds(240,360,90,50);
        setting.setBounds(240,510,48,48);
        login.setBounds(290,510,48,48);
        //添加到布局中
        add(left);
        add(right);
        add(down);
        add(rota);
        add(start);
        add(setting);
        add(login);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //设置颜色和透明度
        g.setColor(new Color(0,0,0,50));
        //游戏区设置位置和大小
        g.fillRect(15,30,200,360);
        //排名区
        g.fillRect(15,405,200,130);
        //右侧排版
        g.fillRect(230,20,110,400);
        g.setColor(new Color(2,2,2,50));
        //得分区
        g.fillRect(240,30,90,70);
        //提示区
        g.fillRect(240,105,90,140);
        //操作区
        g.fillRect(240,255,90,90);
        //边框
        //边框大小
        //转成2d，设置像素大小
        ((Graphics2D)g).setStroke(new BasicStroke(3L));
        //边框颜色
        g.setColor(Color.white);
        //游戏边框位置
        g.drawRect(13,28,204,364);
        //排名区边框
        g.drawRect(13,403,204,134);
        //设置字体大小
        g.setFont(new Font("宋体",Font.PLAIN,20));
        //设置字体颜色
        g.setColor(Color.black);
        //写入文字
        g.drawString("得分",243,50);
        g.drawString("下一个",240,125);
        g.drawString("荣誉榜",25,435);

    }
}