package Thread;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class LambdaThread {
    //��̬�ڲ���
    static class Test implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("һ������");
            }
        }

    }

    public static void main(String[] args) {
        new Thread(new Test()).start();

        //�ֲ��ڲ���
        class Test02 implements Runnable {

            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("һ������");
                }
            }
        }
        new Thread(new Test02()).start();

        //�����ڲ����������ӿڻ���
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("һ������");
            }
        }).start();

    }


}
