package Thread;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class LambdaThread {
    //静态内部类
    static class Test implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("一边听歌");
            }
        }

    }

    public static void main(String[] args) {
        new Thread(new Test()).start();

        //局部内部类
        class Test02 implements Runnable {

            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("一边听歌");
                }
            }
        }
        new Thread(new Test02()).start();

        //匿名内部类必须借助接口或父类
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("一边听歌");
            }
        }).start();

    }


}
