package Pattern23;

/*
 * ����˫�ؼ����ģʽ
 * */
public class SingletonTest03 {

    private static SingletonTest03 instance = null;

    private SingletonTest03() {
    }

    /*����û��ͬ��,����Ч�ʸ�*/
    public static SingletonTest03 getInstance() {
        if (instance == null) {
            SingletonTest03 sc;
            synchronized (SingletonTest03.class) {
                sc = instance;
                if (sc == null) {
                    synchronized (SingletonTest03.class) {
                        if (sc == null) {
                            sc = new SingletonTest03();
                        }
                    }
                    instance = sc;
                }
            }
        }

        return instance;
    }
}
