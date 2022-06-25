package Thread;

/**
 * ThreadLocal:每个线程自身的数据,更改不会影响其他线程
 */
public class ThreadLocalTest02 {

    //更改初始化值
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
            System.out.println(Thread.currentThread().getName() + "得到了" + left);
            threadLocal.set(left - 1);
            System.out.println(Thread.currentThread().getName() + "剩下" + threadLocal.get());
        }
    }
}
