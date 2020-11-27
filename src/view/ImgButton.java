package view;

import javax.swing.*;

/**
 * @author: Qin
 * @Date: 2020/11/25.
 * 设置按钮样式
 */
public class ImgButton extends JButton{
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
    }
}
