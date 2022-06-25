package Pattern23;

/*
 * 测试静态内部类实现单例模式
 * 这种方式:线程安全,调用效率高,并且实现了延时加载!
 * */
public class SingletonTest04 {

    /*类加载的过程是天然安全的*/
    private static class SingletonClassInstance {
        private static final SingletonTest04 instance = new SingletonTest04();
    }


    public static SingletonTest04 getInstance() {
        return SingletonClassInstance.instance;
    }

    private SingletonTest04() {
    }

}
