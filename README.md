# 新建GUI项目，建包，使用mvc模型

# 创建窗体类，继承JFrame，对象序列化。使用构造函数设置窗体大小

# 和背景

```
1 public MainWin() {
2 //起点位置，宽 360 高 600
3 setBounds( 100 , 50 , 360 , 600 );
4 //不可调整大小
5 setResizable(false);
6 //点击关闭按钮关闭窗口
7 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
8 //设置背景图片
9 setBack();
10 }
```
# 设置背景图片

```
1 private void setBack() {
2 ImageIcon icon = new ImageIcon("img/bg.jpg");
3 //使用JLabel显示背景
4 JLabel jl=new JLabel(icon);
5 //设置图片位置
6 jl.setBounds( 0 , 0 , 360 , 600 );
7 //添加组件
8 getContentPane().add(jl);
9 }
```
# 在controller包中创建Main类，创建Main方法，先显示窗体

## 1 //实例化窗体对象

```
2 MainWin mainWin = new MainWin();
3 //使窗体一直显示
4 mainWin.setVisible(true);
```
# 新建绘制容器类，继承JPanel,,设置大小和位置


```
1 public MyPanel() {
2 //设置大小，同窗体一样大
3 setBounds( 0 , 0 , 360 , 600 );
4 }
```
# 在MainWin构造函数中实例化绘制容器类，设置绘制区域

## 1 //实例化绘制容器类

```
2 MyPanel JPanel=new MyPanel();
3 //设置绘制区域
4 //该方法得到一个jLayeredPane类，为Swing容器添加深度，允许容器重叠
5 getLayeredPane().add(JPanel);
```
# 在MyPanel中绘制游戏区域大小200*360，半透明

```
1 @Override
2 protected void paintComponent(Graphics g) {
3 super.paintComponent(g);
4 //设置颜色和透明度
5 g.setColor(new Color( 0 , 0 , 0 , 50 ));
6 //设置位置和大小
7 g.fillRect( 0 , 0 , 200 , 360 );
8 }
```
# 绘制其他区域

## 1 //排名区

```
2 g.fillRect( 15 , 405 , 200 , 130 );
3 //右侧排版
4 g.fillRect( 230 , 20 , 110 , 400 );
5 g.setColor(new Color( 2 , 2 , 2 , 50 ));
6 //得分区
7 g.fillRect( 240 , 30 , 90 , 70 );
8 //提示区
9 g.fillRect( 240 , 105 , 90 , 140 );
10 //操作区
11 g.fillRect( 240 , 255 , 90 , 90 );
```
# 绘制游戏区和排名区的边框

## 1 //边框

## 2 //边框大小

```
3 //转成2d，设置像素大小
4 ((Graphics2D)g).setStroke(new BasicStroke( 3 L));
5 //边框颜色
```

```
6 g.setColor(Color.white);
7 //游戏边框位置
8 g.drawRect( 13 , 28 , 204 , 364 );
9 //排名区边框
10 g.drawRect( 13 , 403 , 204 , 134 );
```
# 标记各区域内容，设置字体大小和颜色

## 1 //设置字体大小

```
2 g.setFont(new Font("宋体",Font.PLAIN, 20 ));
3 //设置字体颜色
4 g.setColor(Color.black);
5 //写入文字
6 g.drawString("得分", 243 , 50 );
7 g.drawString("下一个", 240 , 125 );
8 g.drawString("荣誉榜", 25 , 435 );
```
# 添加按钮

# 设置画布自由布局，添加按钮

## 1 //设置画布为自由布局

```
2 setLayout(null);
3 //取消背景颜色
4 setOpaque(false);
5 //设置按钮并且添加图片
6 //左移
7 JButton left=new ImgButton(new ImageIcon("img/left.png"));
8 //右移
9 JButton right=new ImgButton(new ImageIcon("img/right.png"));
10 //下滑
11 JButton down=new ImgButton(new ImageIcon("img/down.png"));
12 //旋转
13 JButton rota=new ImgButton(new ImageIcon("img/rota.png"));
14 //开始
15 JButton start=new ImgButton(new ImageIcon("img/start.png"));
16 //设置
17 JButton setting=new ImgButton(new ImageIcon("img/setting.png"));
18 //登录
19 JButton login=new ImgButton(new ImageIcon("img/login.png"));
20 //按钮位置
21 left.setBounds( 240 , 255 , 45 , 45 );
22 right.setBounds( 285 , 255 , 45 , 45 );
```

```
23 down.setBounds( 240 , 300 , 45 , 45 );
24 rota.setBounds( 285 , 300 , 45 , 45 );
25 start.setBounds( 240 , 360 , 90 , 50 );
26 setting.setBounds( 240 , 510 , 48 , 48 );
27 login.setBounds( 290 , 510 , 48 , 48 );
28 //添加到布局中
29 add(left);
30 add(right);
31 add(down);
32 add(rota);
33 add(start);
34 add(setting);
35 add(login);
```
# 创建按钮类，实现按钮的样式，创建ImgButtom继承JButton类，生成

# 构造函数，使创建对象时添加图片

## 1 /**

## 2 * 创建对象时添加图片

## 3 */

```
4 public ImgButton(ImageIcon imageIcon) {
5 //设置背景透明
6 setContentAreaFilled(false);
7 //设置图片
8 setIcon(imageIcon);
9 //去除边框
10 setBorder(null);
11 }
```
# 创建游戏画布类GamePanel，继承JPanel,通过构造方法在实例化时设

# 置透明和画布大小位置

```
1 public GamePanel() {
2 //设置透明
3 setOpaque(false);
4 //画布大小位置
5 setBounds( 15 , 30 , 200 , 360 );
6 }
```
# 重写paintComponent方法，绘制方块

```
1 super.paintComponent(g);
2 //绘制方块
```

```
3 g.fillRect( 0 , 0 , 20 , 20 );
```
# 因为游戏方块出现位置要灵活，所以不能写死0,0。新建游戏数据类和

# 操作类GameData、Operation

# 用Main类连接起来，先实例化操作和数据，然后传递到窗体类

## 1 //实例化操作

```
2 Operation op = new Operation();
3 //实例化数据
4 GameData gameData = new GameData();
5 //实例化窗体对象,将数据和操作传递到窗体类
6 MainWin mainWin = new MainWin(op,gameData);
7 //将窗口与操作类关联
8 op.setWin(mainWin);
9 //将数据与操作区关联
10 op.setData(gameData);
```
# MainWin类新加属性Operation和GameData生成构造方法（直接在

# 无参构造方法上改写，免得实例化有参对象时前面写的方法不运行），

# 方便在实例化对象时直接导入操作和数据

# 操作类添加游戏数据和窗体属性，生成getset方法，操作类负责操作游

# 戏数据和窗口显示内容

# 因为游戏画布需要窗体接收的游戏数据，所以添加游戏数据属性，修改

# 构造方法

# 游戏数据类定义X轴与Y轴属性，代替写死的0,0位置-

```
1 g.fillRect( 0 , 0 , 20 , 20 );
```

