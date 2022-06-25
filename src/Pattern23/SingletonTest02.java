package Pattern23;

/*
 * 测试懒汉式单例模式
 * */
public class SingletonTest02 {

    /*类初始化时,不初始化这个对象(延时加载,真正用的时候再创建)*/
    private static SingletonTest02 instance;

    private SingletonTest02() {
    }

    /*方法没有同步,调用效率低*/
    public static synchronized SingletonTest02 getInstance() {
        if (instance == null) {
            instance = new SingletonTest02();
        }
        return instance;
    }
}
