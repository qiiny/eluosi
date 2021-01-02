package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: Qin
 * @Date: 2020/11/25.
 * 设置按钮样式
 */
public abstract class ImgButton extends JButton{
    /**
     * 序列化
     */
    private static final long serialVersionUID=3L;

    /**
     * 创建对象时添加图片
     */
    public ImgButton(ImageIcon imageIcon) {
        //设置背景透明
        setContentAreaFilled(false);
        //设置图片
        setIcon(imageIcon);
        //去除边框
        setBorder(null);
        //取消截获按键
        setFocusable(false);
        //添加按键检测
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                onClick();
            }
        });
    }
    /**
     *  按钮点击时的抽象方法
     */
    public abstract void onClick();
}
