package Thread;

import org.apache.log4j.chainsaw.Main;

//volatile:用于保证数据的同步,也就是可见性
public class Volatile {
    private volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (num == 0) {
                //此处不要编写代码

            }
        }).start();

        Thread.sleep(1000);
        num = 1;
    }

}
