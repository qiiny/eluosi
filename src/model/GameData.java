package model;


import java.awt.*;

/**
 * @author: Qin
 * @Date: 2020/11/27.
 * 游戏数据
 */
public class GameData {
    /**
     * 方块，方便调用设为静态
     */
    public static Blocks[] BLOCKS = new Blocks[]{
            //反L
            new Blocks(new int[]{-1, 0, 1, 1}, new int[]{0, 0, 0, 1}),
            //-—
            new Blocks(new int[]{-1, 0, 1, 2}, new int[]{0, 0, 0, 0}),
            //正L
            new Blocks(new int[]{-1, -1, 0, 1}, new int[]{0, 1, 0, 0}),
            //正Z
            new Blocks(new int[]{-1, 0, 0, 1}, new int[]{0, 0, 1, 1}),
            //田
            new Blocks(new int[]{0, 0, 1, 1}, new int[]{0, 0, 1, 1}),
            //反Z
            new Blocks(new int[]{-1, 0, 0, 1}, new int[]{1, 0, 1, 0}),
            //T
            new Blocks(new int[]{-1, 0, 0, 1}, new int[]{0, 0, 1, 0})
    };
    /**
     * 偏移量，横向与纵向
     */
    public int x;
    public int y;
    /**
     * 存放格子的数组
     */
    public int[][] exist;
    /**
     * 单个方块
     */
    public Blocks blocks;

    /**
     * 初始化成员
     */
    public GameData() {
        y = -2;
        x = 4;
        //初始化保存已有格子的数组
        exist=new int[10][20];
        //单个方块
        blocks = new Blocks(BLOCKS[1]);
    }

    /**
     * 移动方法
     *
     * @param isH  水平方向
     * @param step 步长
     */
    public void move(boolean isH, int step) {
        //定义是否允许移动
        boolean isAllow = true;
        //如果是水平的
        if (isH) {
            //遍历方块
            for (Point point :
                    blocks.points) {
                if (point.x + x + step < 0 || point.x + x + step > 9) {
                    isAllow = false;
                }
            }
            if (isAllow) {
                //横向移动
                x += step;
            }
        } else {
            for (Point point : blocks.points) {
                if (point.y + y + step > 17 || exist[point.x+x][point.y+y+2]!=0) {
                    saveBlock();
                    isAllow = false;
                }
            }
            if (isAllow) {
                //纵向移动
                y += step;
            }

        }
    }

    /**
     * 旋转功能
     */
    public void rote() {
        for (Point point : blocks.points) {
            int _x = -point.y + x;
            int _y = point.x + y;
            if (_x > 9 || _x < 0) {
                return;
            }
            if (_y > 17) {
                return;
            }
        }
        for (Point point : blocks.points) {
            //临时变量，位置交换
            int temp = point.x;
            point.x = -point.y;
            point.y = temp;
        }
    }
    /**
     * 保存下落的方块
     */
    public void saveBlock(){
        //遍历下落的方块
        for (Point point : blocks.points) {
            //出现的位置+偏移值，用过的位置为1
            exist[point.x+x][point.y+y+2]=1;
        }
    }
}
