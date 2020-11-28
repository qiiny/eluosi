package model;


/**
 * @author: Qin
 * @Date: 2020/11/27.
 * 游戏数据
 */
public class GameData {
    /**
     * 偏移量，横向与纵向
     */
    public int x;
    public int y;
    /**
     * 单个方块
     */
    public Blocks blocks;
    /**
     * 方块，方便调用设为静态
     */
    public static Blocks[] BLOCKS=new Blocks[] {
        //左L
        new Blocks(new int[]{-1,0,1,1},new int[]{0,0,0,1}),
        //-—
        new Blocks(new int[] {-1, 0, 1,2},new int[]{0,0,0,0}),
        //右L
         new Blocks(new int[]{-1,-1,0,1},new int[]{0,1,0,0}),
    };

    /**
     * 初始化成员
     */
    public GameData(){
        y=0;
        x=4;
        //单个方块
        blocks=new Blocks(BLOCKS[1]);
    }

    /**
     * 移动方法
     * @param isH  水平方向
     * @param step 步长
     */
    public void move(boolean isH,int step){
        //如果是水平的
        if (isH) {
            //横向移动
            x+=step;
        }else {
            //纵向移动
            y+=step;
        }
    }

}
