package Pattern23;

/*
 * ���Զ���ʽ����ģʽ
 * */
public class SingletonTest01 {
    /*���ʼ��ʱ,���������������(û����ʱ���ص�����)
    * ���ڼ�����ʱ,��Ȼ�����̰߳�ȫ��*/
    private static SingletonTest01 instance = new SingletonTest01();

    private SingletonTest01() {
    }

    /*����û��ͬ��,����Ч�ʸ�*/
    public static SingletonTest01 getInstance() {
        return instance;
    }
}
