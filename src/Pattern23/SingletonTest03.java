package Pattern23;

/*
 * 测试双重检测锁模式
 * */
public class SingletonTest03 {

    private static SingletonTest03 instance = null;

    private SingletonTest03() {
    }

    /*方法没有同步,调用效率高*/
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
