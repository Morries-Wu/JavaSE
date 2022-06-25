package Thread;

/**
 * ����ģʽ:��·,�ڶ��̻߳�����,�������һ������
 * 1��������˽�л�-->�����ⲿnew������
 * 2������˽�еľ�̬����-->�洢����ĵ�ַ
 * 3���ṩ�����ľ�̬����-->��ȡ����
 */


public class DoubleCheckedLocking {
    //2���ṩ˽�еľ�̬����
    private static volatile DoubleCheckedLocking instance;

    //�]��volatile�����߳̿��ܷ���һ��û�г�ʼ���Ķ���
    //1��������˽�л�
    private DoubleCheckedLocking() {

    }

    //3���ṩ�����ľ�̬����
    public static DoubleCheckedLocking getInstance() {
        if (instance != null) {
            //���ⲻ��Ҫ��ͬ��,�Ѿ����ڵĶ���
            return instance;
        }

        synchronized (DoubleCheckedLocking.class) {
            if (null == instance) {
                instance = new DoubleCheckedLocking();
                /**
                 * 1�����ٿռ�2����ʼ������3�����ض���ĵ�ַ������
                 */
            }
            return instance;
        }

    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(DoubleCheckedLocking.getInstance());
        });
        thread.start();
        System.out.println(DoubleCheckedLocking.getInstance());
    }
}
