package Thread;

/**
 * ָ������:����ִ��˳����Ԥ�ڲ�һ��
 * Ŀ��:�������
 */
public class HappenBefore {
    //����1
    private static int a = 0;
    //����2
    private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        /**
         * �߳�1��ȡ����
         * �߳�2��������
         */
        for (int i = 0; i < 10; i++) {
            a = 0;
            flag = false;
            Thread thread01 = new Thread(() -> {
                a = 1;
                flag = true;
            });

            Thread thread02 = new Thread(() -> {
                if (flag) {
                    a *= 1;
                }
                //ָ������
                if (a == 0) {
                    System.out.println("happen before" + a);
                }
            });

            thread01.start();
            thread02.start();

            //�ϲ��߳�
            thread01.join();
            thread02.join();
        }

    }

}
