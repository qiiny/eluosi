package model;

import java.awt.*;
import java.util.Arrays;

/**
 * 方块类
 * @author: Qin
 * @Date: 2020/11/28.
 */
public class Blocks {
    /**
     *用point确定位置
     */
    public Point[] points;
    /**
     * 单个方块组成的数量
     */
    final int PIXEL=4;

    /**
     * 获取单个方块位置
     * @param block 传递过来的某个方块
     */
    public Blocks(Blocks block){
        //遍历构成方块的四个像素
        points=new Point[4];
        for (int i = 0; i < PIXEL; i++) {
            //初始化顶点的大小
            //把每一个像素的位置存到顶点去
            points[i] = new Point(block.points[i].x, block.points[i].y);
        }
    }
    /**
     * 定义方块
     * @param xs 横坐标数组
     * @param ys 纵坐标数组
     */
    public Blocks(int[] xs,int[] ys){
        //循环四个顶点
        points=new Point[4];
        for (int i = 0; i < PIXEL; i++) {
            //往方块数组存方块
            points[i] = new Point(xs[i], ys[i]);
        }
    }
}
