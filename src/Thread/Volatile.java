package Thread;

import org.apache.log4j.chainsaw.Main;

//volatile:���ڱ�֤���ݵ�ͬ��,Ҳ���ǿɼ���
public class Volatile {
    private volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (num == 0) {
                //�˴���Ҫ��д����

            }
        }).start();

        Thread.sleep(1000);
        num = 1;
    }

}
