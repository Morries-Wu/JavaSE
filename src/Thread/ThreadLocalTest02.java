package Thread;

/**
 * ThreadLocal:ÿ���߳����������,���Ĳ���Ӱ�������߳�
 */
public class ThreadLocalTest02 {

    //���ĳ�ʼ��ֵ
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return 1;
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new MyRun()).start();
        }

    }

    public static class MyRun implements Runnable {

        @Override
        public void run() {
            Integer left = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + "�õ���" + left);
            threadLocal.set(left - 1);
            System.out.println(Thread.currentThread().getName() + "ʣ��" + threadLocal.get());
        }
    }
}
