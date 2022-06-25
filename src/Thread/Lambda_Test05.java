package Thread;

//lambda表达式 简化线程(用一次)的使用
public class Lambda_Test05 implements Runnable {

    /**
     * 一个类只用一次的情况下，为了提升性能我们可以把它做内部 做内部类的好处是随着外部类的使用进行加载 如果外部类不用就不会加载
     */

    // 静态内部类
    static class test implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("_____________");
            }
        }
    }

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        new Thread(new test()).start();

        // 局部内部类
        class test2 implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("二二二");
                }
            }
        }
        new Thread(new test2()).start();

        // 匿名内部类 必须借助接口或者父类
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("三三三");
                }
            }
        }).start();

        // JDK8 简化lambda只能推导一个方法,多个方法推导不了
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("四四四");
            }
        }).start();
    }

}
