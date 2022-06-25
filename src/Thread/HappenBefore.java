package Thread;

/**
 * 指令重排:代码执行顺序与预期不一致
 * 目的:提高性能
 */
public class HappenBefore {
    //变量1
    private static int a = 0;
    //变量2
    private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        /**
         * 线程1读取数据
         * 线程2更改数据
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
                //指令重排
                if (a == 0) {
                    System.out.println("happen before" + a);
                }
            });

            thread01.start();
            thread02.start();

            //合并线程
            thread01.join();
            thread02.join();
        }

    }

}
