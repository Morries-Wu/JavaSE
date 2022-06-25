package Thread;

/**
 * ThreadLocal:���������Ļ���
 * 1��������:������þ������������߳���
 * 2��run����:���߳��������
 */
public class ThreadLocalTest03 {

    //���ĳ�ʼ��ֵ
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return 1;
        }
    };

    public static void main(String[] args) {
        new Thread(new MyRun()).start();
    }

    public static class MyRun implements Runnable {
        public MyRun() {
            System.out.println(Thread.currentThread().getName() + "ʣ��" + threadLocal.get());
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "ʣ��" + threadLocal.get());
        }
    }
}
