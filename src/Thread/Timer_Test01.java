package Thread;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

//任务调度:Timer和TimerTask
//任务可以安排一次执行,或者定期重复执行
public class Timer_Test01 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        /**
         *执行安排
         *timer.schedule(new MyTask(), 1000); 一次执行
         *timer.schedule(new MyTask(), 1000,2000); 执行多次
         */

        Calendar cal = new GregorianCalendar(2022, 1, 11, 16, 55, 10);
        timer.schedule(new MyTask(), cal.getTime(), 2000);// 五秒后开始
    }
}

class MyTask extends TimerTask {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("大脑放松一会");
        }
        System.out.println("---------end----------");
    }
}
