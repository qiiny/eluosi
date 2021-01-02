package view;

import controller.Operation;

import javax.swing.*;
import java.awt.*;

/**
 * @author: Qin
 * @Date: 2020/11/24.
 * 继承绘图容器
 */
public class MyPanel extends JPanel {
    private static final long serialVersionUID=2L;
    /**
     * 设按钮为属性，方便操作
     */
    JButton left;
    JButton right;
    JButton down;
    JButton rota;
    JButton start;
    JButton login;

    public MyPanel(Operation operation) {
        //设置大小，同窗体一样大
        setBounds(0,0,360,600);
        //设置画布为自由布局
        setLayout(null);
        //取消背景颜色
        setOpaque(false);
        //设置按钮并且添加图片
        //左移
        left=operation.left;
        //右移
        right= operation.right;
        //下滑
        down=operation.down;
        //旋转
        rota= operation.rota;
        //开始
        start= operation.start;
        //登录
        login=operation.login;
        //设置按钮透明
        setTransparent();
        //按钮位置
        left.setBounds(240,255,45,45);
        right.setBounds(285,255,45,45);
        down.setBounds(240,300,45,45);
        rota.setBounds(285,300,45,45);
        start.setBounds(240,360,90,50);
        login.setBounds(290,510,48,48);
        //添加到布局中
        add(left);
        add(right);
        add(down);
        add(rota);
        add(start);
        add(login);
        setFocusable(false);
    }

    /**
     * 按钮透明
     */
    private void setTransparent() {
        start.setContentAreaFilled(false);
        //去掉选择框
        start.setFocusPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //设置颜色和透明度
        g.setColor(new Color(150,150,150,50));
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
