package Pattern23;

/*
 * ���Ծ�̬�ڲ���ʵ�ֵ���ģʽ
 * ���ַ�ʽ:�̰߳�ȫ,����Ч�ʸ�,����ʵ������ʱ����!
 * */
public class SingletonTest04 {

    /*����صĹ�������Ȼ��ȫ��*/
    private static class SingletonClassInstance {
        private static final SingletonTest04 instance = new SingletonTest04();
    }


    public static SingletonTest04 getInstance() {
        return SingletonClassInstance.instance;
    }

    private SingletonTest04() {
    }

}
