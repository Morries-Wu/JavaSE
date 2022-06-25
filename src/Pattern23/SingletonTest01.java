package Pattern23;

/*
 * 测试饿汉式单例模式
 * */
public class SingletonTest01 {
    /*类初始化时,立即加载这个对象(没有延时加载的优势)
    * 由于加载类时,天然的是线程安全的*/
    private static SingletonTest01 instance = new SingletonTest01();

    private SingletonTest01() {
    }

    /*方法没有同步,调用效率高*/
    public static SingletonTest01 getInstance() {
        return instance;
    }
}
