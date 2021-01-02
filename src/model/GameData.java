package model;


import controller.DataDao;

import java.awt.*;
import java.sql.SQLException;
import java.util.Random;

/**
 * 游戏数据
 * @author: Qin
 * @Date: 2020/11/27.
 *
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
            new Blocks(new int[]{0, 0, 1, 1}, new int[]{0, 1, 0, 1}),
            //反Z
            new Blocks(new int[]{-1, 0, 0, 1}, new int[]{1, 0, 1, 0}),
            //T
            new Blocks(new int[]{-1, 0, 0, 1}, new int[]{0, 0, 1, 0})
    };
    /**
     * 透明度
     */
    int op=100;

    /**
     * 颜色
     */
    public Color[] colors=new Color[]{
            new Color(255, 0, 0),
            new Color(0, 255, 0),
            new Color(0, 0, 255),
            new Color(0, 255, 255),
            new Color(255, 255, 0),
            new Color(255, 0, 255),
            new Color(255, 175, 175)
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
    public String name;
    public String password;
    public Blocks blocks;
    /**
     * 消除的格数
     */
    int[] removedNums;
    /**
     * 随机数
     */
    Random random;
    /**
     * 分数
     */
    public int score;
    /**
     * 提示下一個
     */
    public int next;
    /**
     * 现在的格子
     */
    public static int current;
    /**
     * 游戏状态
     */
    public int status;
    /**
     * 初始化成员
     */
    public GameData() {
        init();
    }
    DataDao dataDao=new DataDao();
    /**
     * 方便外面调用构造函数
     */
    public void init(){
        //初始化保存已有格子的数组
        exist=new int[10][20];
        //初始化
        random=new Random();
        //获取下一个
        next= random.nextInt(7);
        //初始化格子
        initBlock();
    }
    /**
     * 移动方法
     *
     * @param isH  水平方向
     * @param step 步长
     */
    public boolean move(boolean isH, int step) {
        //定义是否允许删除
        boolean isRemove = false;
        //如果是水平的
        if (isH) {
            //遍历方块
            for (Point point : blocks.points) {
                //如果格子旁边有格子，不能再移动
                if (point.x + x + step < 0 || point.x + x + step > 9||exist[point.x+x+step][point.y+y+2]!=0) {
                    return false;
                }
            }
            //移动
            x+=step;
        } else {
            for (Point point : blocks.points) {
                //如果格子到底不能再向下，或者位置已有格子也不能下落
                if (point.y + y + step > 17 || exist[point.x+x][point.y+y+2+step]!=0) {
                    saveBlock();
                    isRemove=isRemoveBlock();
                    if (isRemove){
                        removeline();
                    }
                    if (isDie()){
                        //死亡提示
                        status=3;
                        saveScore();
                    }
                    initBlock();
                    return true;
                }
            }
                //纵向移动
                y += step;
        }
        return isRemove;
    }

    /**
     * 初始化方块，实现重新出现格子
     */
    private void initBlock() {
        y = -2;
        x = 4;
        //初始化以消除的数组
        removedNums=new int[20];
        //单个方块
        blocks = new Blocks(BLOCKS[next]);
        //把随机数存起来
        current=next;
        //获取随机数
        next= random.nextInt(7);
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
            if (_y > 17||_y<0) {
                return;
            }
            //已存在的不能旋转
            if (exist[_x][_y]!=0){
                return;
            }
            if (current==4){
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
     * 保存下落的方块组
     */
    public void saveBlock(){
        //遍历下落的方块
        for (Point point : blocks.points) {
            //出现的位置+偏移值，用过的位置为1
            exist[point.x+x][point.y+y+2]=current+1;
        }
    }

    /**
     * 判断是否消除行列
     * @return
     */
    public boolean isRemoveBlock(){
        //是否消除
        boolean removed = false;
        //位置是否存在格子
        boolean isEmpty;
        //遍历存储的方块
        int heightMax=19;
        int heightMin=2;
        int widthMax=10;
        for (int i = heightMax; i >=heightMin ; i--) {
            isEmpty=false;
            for (int j = 0; j < widthMax;j++){
               if (exist[j][i]==0){
                   isEmpty = true;
                   break;
               }
            }
            if (!isEmpty) {
                //位置存在格子
                removed = true;
                //消去的格子上面一行自动下落
                removedNums[i-1]=removedNums[i]+1;
            }else {
                //删除的行数不变
                removedNums[i-1]=removedNums[i];
            }
        }
        return removed;
    }

    /**
     * 删除行数
     */
    private void removeline(){
        //遍历存储的方块
        int heightMax=19;
        int heightMin=2;
        int widthMax=10;
        for (int i = heightMax; i >=heightMin ; i--) {
            for (int j = 0; j < widthMax; j++) {
                //消行
                exist[j][i+removedNums[i]]=exist[j][i];
            }
        }
        score+=removedNums[2]*10;
    }
    /**
     * 检查是否死亡
     * @return
     */
    public boolean isDie(){
        //是否碰到上面
        for (int i = 0; i <10;i++){
            if (exist[i][3]!=0){
                return true;
            }
        }
        return false;
    }
    public String getScore() {
        return ""+score;
    }
    public void saveScore(){
        if (name!=null&&password!=null){
            try {
                User byName = dataDao.findByName(name);
                if (byName == null) {
                    dataDao.add(new User(name,password,score));
                }else {
                    if (byName.getScore()<score){
                        dataDao.update(score,byName.getId());
                    }
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
