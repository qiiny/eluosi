package view;


import controller.DataDao;
import model.GameData;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author: Qin
 * @Date: 2021/1/2.
 */
public class NewDialog extends JDialog{
    private static final long serialVersionUID=9L;
    /**
     * 游戏数据
     */
    public GameData gameData;
    public JLabel buttonLabel;
    JTextField nameField;
    JPasswordField passwordField;
    public static final int OVER=0;
    public static final int LOGIN=1;
    public static final int SETTING=2;
    DataDao dataDao=new DataDao();
    public NewDialog(MainWin mainWin, GameData gameData,int model) {
        super(mainWin,true);
        this.gameData = gameData;
        gameData.status=2;
        //按钮
        buttonLabel = new JLabel("默认",JLabel.CENTER);
        buttonLabel.setFont(new Font("华文彩云",Font.BOLD,20));
        buttonLabel.setForeground(Color.RED);
        buttonLabel.setBounds(176,175,105,53);
        if (model==OVER){
            over();
        }else if (model == LOGIN){
            login();
        }else if (model == SETTING){
            //结束
            JLabel overLabel=new JLabel("设置",JLabel.CENTER);
            overLabel.setFont(new Font("华文彩云",Font.BOLD,30));
            overLabel.setForeground(Color.RED);
            overLabel.setBounds(0,70,339,95);
            getLayeredPane().add(overLabel);
        }
        setSize(340,240);
        setLocationRelativeTo(mainWin);
        this.gameData=gameData;
        JLabel bg=new JLabel(new ImageIcon("img/diglogbg.png"));
        add(bg);
        //去除多余部分
        setUndecorated(true);
        getLayeredPane().add(buttonLabel);
        //画布
        JPanel mainPanel=new JPanel();
        mainPanel.setBounds(0,78,340,96);
        mainPanel.setLayout(null);
        mainPanel.setOpaque(false);
        //添加点击事件
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getX()>255&&e.getX()<321){
                    if (e.getY() > 20&&e.getY() <78){
                        closeDialog();
                    }
                }
                if (e.getX()>176&&e.getX()<281){
                    if (e.getY() > 175&&e.getY() <228){
                        if (model==OVER){
                            gameData.score=0;
                            closeDialog();
                        }else if (model == LOGIN) {
                            saveData();
                            closeDialog();
                        }
                    }
                }

            }


            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private void saveData() {
        gameData.name=nameField.getText();
        gameData.password= String.valueOf(passwordField.getPassword());
    }

    private void login() {
        buttonLabel.setText("登录/注册");
        //用户名
        JLabel name=new JLabel("昵称",JLabel.CENTER);
        name.setFont(new Font("华文彩云",Font.BOLD,30));
        name.setForeground(Color.RED);
        name.setBounds(8,86,78,36);
        //密码
        JLabel password=new JLabel("密码",JLabel.CENTER);
        password.setFont(new Font("华文彩云",Font.BOLD,30));
        password.setForeground(Color.RED);
        password.setBounds(8,134,78,36);
        //用户名框
        nameField=new JTextField();
        passwordField=new JPasswordField();
        nameField.setBounds(103,86,210,36);
        passwordField.setBounds(103,134,210,36);

        getLayeredPane().add(name);
        getLayeredPane().add(password);
        getLayeredPane().add(nameField);
        getLayeredPane().add(passwordField);
    }

    public void over(){
        //结束
        JLabel overLabel=new JLabel("游戏结束，分数："+gameData.getScore(),JLabel.CENTER);
        overLabel.setFont(new Font("华文彩云",Font.BOLD,30));
        overLabel.setForeground(Color.RED);
        overLabel.setBounds(0,70,339,95);
        getLayeredPane().add(overLabel);
    }
    public void openDialog(){
        setVisible(true);
    }
    public void closeDialog(){
        setVisible(false);
        gameData.status=1;
    }

}
