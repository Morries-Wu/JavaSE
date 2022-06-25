package Thread;

/**
 * ThreadLocal:分析上下文环境
 * 1、构造器:哪里调用就属于哪里找线程体
 * 2、run方法:本线程体自身的
 */
public class ThreadLocalTest03 {

    //更改初始化值
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
            System.out.println(Thread.currentThread().getName() + "剩下" + threadLocal.get());
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "剩下" + threadLocal.get());
        }
    }
}
