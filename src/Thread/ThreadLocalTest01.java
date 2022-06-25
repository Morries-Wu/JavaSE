package Thread;

/**
 * ThreadLocal:ÿ���߳�����Ĵ洢���ء��ֲ�����
 * get/set/initalValue
 */
public class ThreadLocalTest01 {
    //private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    //���ĳ�ʼ��ֵ
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return 200;
        }
    };


    public static void main(String[] args) {
        //��ȡֵ
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        //����ֵ
        threadLocal.set(99);
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        new Thread(new MyRun()).start();
    }

    public static class MyRun implements Runnable {

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 99));
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        }
    }
}
