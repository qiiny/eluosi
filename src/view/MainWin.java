package view;

import controller.Operation;
import model.GameData;

import javax.swing.*;
import java.awt.*;

/**
 * @author: Qin
 * @Date: 2020/11/24.
 * 窗体类
 */
public class MainWin extends JFrame {
    private static final long serialVersionUID=1L;
    /**
     * 新建容器对象
     */
    Container layeredPanel;
    /**
     * 新建游戏画布对象
     */
    GamePanel gamePanel;

    /**
     * 新建操作对象
     */
    Operation operation;

    /**
     * 新建数据对象
     */
    GameData gameData;
    public MainWin(Operation operation,GameData gameData) {
        //获取操作
        this.operation = operation;
        //获取数据
        this.gameData = gameData;
        //起点位置，宽360高600
        setBounds(100,50,360,600);
        //不可调整大小
        setResizable(false);
        //点击关闭按钮关闭窗口
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置背景图片
        setBack();
        //实例化绘制容器类
        MyPanel JPanel=new MyPanel(operation);
        //得到容器
        layeredPanel=getLayeredPane();
        //设置绘制区域
        //该方法得到一个jLayeredPane类，为Swing容器添加深度，允许容器重叠
        layeredPanel.add(JPanel);
        //添加游戏界面画布
        setGamePanel();
    }


    private void setGamePanel() {
        //实例化GamePanel
        gamePanel=new GamePanel(gameData);
        //添加游戏画布
        layeredPanel.add(gamePanel);
    }

    /**
     * 设置背景图片
     */
    private void setBack() {
        ImageIcon icon = new ImageIcon("img/bg.jpg");
        //使用JLabel显示背景
        JLabel jl=new JLabel(icon);
        //设置图片位置
        jl.setBounds(0,0,360,600);
        //添加组件
        getContentPane().add(jl);
    }

    /**
     * 获取游戏区
     * @return 返回游戏区
     */
    public GamePanel getGamePanel(){
        return gamePanel;
    }
}
