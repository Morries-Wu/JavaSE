package Pattern23;

/*
 * ��������ʽ����ģʽ
 * */
public class SingletonTest02 {

    /*���ʼ��ʱ,����ʼ���������(��ʱ����,�����õ�ʱ���ٴ���)*/
    private static SingletonTest02 instance;

    private SingletonTest02() {
    }

    /*����û��ͬ��,����Ч�ʵ�*/
    public static synchronized SingletonTest02 getInstance() {
        if (instance == null) {
            instance = new SingletonTest02();
        }
        return instance;
    }
}
