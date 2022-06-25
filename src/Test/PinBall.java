package Test;

import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;

public class PinBall {
    // 创建窗口对象
    private Frame frame = new Frame("弹球小游戏");
    // 桌面宽度
    private final int TABLE_WIDTH = 300;
    // 桌面高度
    private final int TABLE_HEIGHT = 400;
    // 球拍的高度和宽度
    private final int RACKET_WIDTH = 60;
    private final int RACKET_HEIGHT = 20;
    // 小球大小
    private final int BALL_SIZE = 16;
    // 定义变量，记录小球的坐标
    private int ballX = 120;
    private int ballY = 20;
    // 定义变量，记录小球在x和y方向上分别移动的速度
    private int speedY = 10;
    private int speedX = 5;
    // 定义变量，定义球拍的坐标
    private int racketX = 120;
    private final int racketY = 340;
    // 定义变量，标识当前游戏是否结束
    private boolean isOver = false;
    // 声明一个定时器
    Timer timer;

    // 自定义一个类，继承Canvas充当画布
    private class MyCanvas extends Canvas {
        public void paint(Graphics g) {
            // 绘制内容
            if (isOver) {
                // 游戏结束
                g.setColor(Color.red);
                g.setFont(new Font("Times", Font.BOLD, 30));
                g.drawString("游戏结束", 100, 100);
            } else {
                // 游戏中
                // 绘制小球
                g.setColor(Color.red);
                g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
                // 绘制球拍
                g.setColor(Color.PINK);
                g.fillRect(racketX, racketY, RACKET_WIDTH, RACKET_HEIGHT);
            }
        }
    }

    // 创建绘画区域
    MyCanvas drawArea = new MyCanvas();

    public void init() {
        // 组装视图，游戏逻辑的控制
        // 完成球拍坐标的变化
        KeyListener listener = new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                // 获取当前按下的键
                int KeyCode = e.getKeyCode();
                if (KeyCode == KeyEvent.VK_LEFT) {
                    // <-应该向左移动
                    if (racketX > 0)
                        racketX -= 10;
                }
                if (KeyCode == KeyEvent.VK_RIGHT) {
                    // <-应该向右移动
                    if (racketX < (TABLE_WIDTH - RACKET_WIDTH)) {
                        racketX += 10;
                    }
                }
            }
        };
        // 给Frame和drawArea注册监听
        frame.addKeyListener(listener);
        drawArea.addKeyListener(listener);
        // 小球坐标的控制
        ActionListener task = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 根据边界范围，修正速度
                if (ballX <= 0 || ballX >= TABLE_WIDTH - BALL_SIZE) {
                    speedX = -speedX;
                }
                if (ballY <= 0 || (ballY > racketY - BALL_SIZE && ballX > racketX && ballX < racketX + RACKET_WIDTH)) {
                    speedY = -speedY;
                }
                if (ballY > racketY - BALL_SIZE && (ballX < racketX || ballX > racketX + RACKET_WIDTH)) {
                    // 当前小球超出了球拍的范围，游戏结束
                    // 停止定时器
                    timer.stop();
                    // 修改游戏是否结束标记
                    isOver = true;
                    drawArea.repaint();
                }
                // 更新小球的坐标，重绘界面
                ballX += speedX;
                ballY += speedY;
                // 重绘界面
                drawArea.repaint();
            }
        };
        timer = new Timer(50, task);
        timer.start();
        // 设置frame最佳大小，并可见
        drawArea.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
        frame.add(drawArea);
        frame.pack();
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new PinBall().init();
    }
}