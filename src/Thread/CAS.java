package Thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS:�Ƚϲ�����
 */
public class CAS {
    //���
    private static AtomicInteger stock = new AtomicInteger();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    //ģ��������ʱ
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer left = stock.decrementAndGet();
                if (left < 1) {
                    System.out.println("������");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "����һ����Ʒ" + "��ʣ" + left);
            }).start();
        }

    }
}
