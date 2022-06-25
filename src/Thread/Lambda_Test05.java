package Thread;

//lambda���ʽ ���߳�(��һ��)��ʹ��
public class Lambda_Test05 implements Runnable {

    /**
     * һ����ֻ��һ�ε�����£�Ϊ�������������ǿ��԰������ڲ� ���ڲ���ĺô��������ⲿ���ʹ�ý��м��� ����ⲿ�಻�þͲ������
     */

    // ��̬�ڲ���
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

        // �ֲ��ڲ���
        class test2 implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("������");
                }
            }
        }
        new Thread(new test2()).start();

        // �����ڲ��� ��������ӿڻ��߸���
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("������");
                }
            }
        }).start();

        // JDK8 ��lambdaֻ���Ƶ�һ������,��������Ƶ�����
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("������");
            }
        }).start();
    }

}
