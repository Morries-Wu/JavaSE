package Thread;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

//�������:Timer��TimerTask
//������԰���һ��ִ��,���߶����ظ�ִ��
public class Timer_Test01 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        /**
         *ִ�а���
         *timer.schedule(new MyTask(), 1000); һ��ִ��
         *timer.schedule(new MyTask(), 1000,2000); ִ�ж��
         */

        Calendar cal = new GregorianCalendar(2022, 1, 11, 16, 55, 10);
        timer.schedule(new MyTask(), cal.getTime(), 2000);// �����ʼ
    }
}

class MyTask extends TimerTask {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("���Է���һ��");
        }
        System.out.println("---------end----------");
    }
}
