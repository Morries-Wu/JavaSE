package Test;

import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;

public class PinBall {
    // �������ڶ���
    private Frame frame = new Frame("����С��Ϸ");
    // ������
    private final int TABLE_WIDTH = 300;
    // ����߶�
    private final int TABLE_HEIGHT = 400;
    // ���ĵĸ߶ȺͿ��
    private final int RACKET_WIDTH = 60;
    private final int RACKET_HEIGHT = 20;
    // С���С
    private final int BALL_SIZE = 16;
    // �����������¼С�������
    private int ballX = 120;
    private int ballY = 20;
    // �����������¼С����x��y�����Ϸֱ��ƶ����ٶ�
    private int speedY = 10;
    private int speedX = 5;
    // ����������������ĵ�����
    private int racketX = 120;
    private final int racketY = 340;
    // �����������ʶ��ǰ��Ϸ�Ƿ����
    private boolean isOver = false;
    // ����һ����ʱ��
    Timer timer;

    // �Զ���һ���࣬�̳�Canvas�䵱����
    private class MyCanvas extends Canvas {
        public void paint(Graphics g) {
            // ��������
            if (isOver) {
                // ��Ϸ����
                g.setColor(Color.red);
                g.setFont(new Font("Times", Font.BOLD, 30));
                g.drawString("��Ϸ����", 100, 100);
            } else {
                // ��Ϸ��
                // ����С��
                g.setColor(Color.red);
                g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
                // ��������
                g.setColor(Color.PINK);
                g.fillRect(racketX, racketY, RACKET_WIDTH, RACKET_HEIGHT);
            }
        }
    }

    // �����滭����
    MyCanvas drawArea = new MyCanvas();

    public void init() {
        // ��װ��ͼ����Ϸ�߼��Ŀ���
        // �����������ı仯
        KeyListener listener = new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                // ��ȡ��ǰ���µļ�
                int KeyCode = e.getKeyCode();
                if (KeyCode == KeyEvent.VK_LEFT) {
                    // <-Ӧ�������ƶ�
                    if (racketX > 0)
                        racketX -= 10;
                }
                if (KeyCode == KeyEvent.VK_RIGHT) {
                    // <-Ӧ�������ƶ�
                    if (racketX < (TABLE_WIDTH - RACKET_WIDTH)) {
                        racketX += 10;
                    }
                }
            }
        };
        // ��Frame��drawAreaע�����
        frame.addKeyListener(listener);
        drawArea.addKeyListener(listener);
        // С������Ŀ���
        ActionListener task = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ���ݱ߽緶Χ�������ٶ�
                if (ballX <= 0 || ballX >= TABLE_WIDTH - BALL_SIZE) {
                    speedX = -speedX;
                }
                if (ballY <= 0 || (ballY > racketY - BALL_SIZE && ballX > racketX && ballX < racketX + RACKET_WIDTH)) {
                    speedY = -speedY;
                }
                if (ballY > racketY - BALL_SIZE && (ballX < racketX || ballX > racketX + RACKET_WIDTH)) {
                    // ��ǰС�򳬳������ĵķ�Χ����Ϸ����
                    // ֹͣ��ʱ��
                    timer.stop();
                    // �޸���Ϸ�Ƿ�������
                    isOver = true;
                    drawArea.repaint();
                }
                // ����С������꣬�ػ����
                ballX += speedX;
                ballY += speedY;
                // �ػ����
                drawArea.repaint();
            }
        };
        timer = new Timer(50, task);
        timer.start();
        // ����frame��Ѵ�С�����ɼ�
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