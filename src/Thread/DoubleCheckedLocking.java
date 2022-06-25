package Thread;

/**
 * 单例模式:套路,在多线程环境下,对外存在一个对象
 * 1、构造器私有化-->避免外部new构造器
 * 2、构造私有的静态属性-->存储对象的地址
 * 3、提供公共的静态方法-->获取属性
 */


public class DoubleCheckedLocking {
    //2、提供私有的静态属性
    private static volatile DoubleCheckedLocking instance;

    //沒有volatile其他线程可能访问一个没有初始化的对象
    //1、构造器私有化
    private DoubleCheckedLocking() {

    }

    //3、提供公共的静态方法
    public static DoubleCheckedLocking getInstance() {
        if (instance != null) {
            //避免不必要的同步,已经存在的对象
            return instance;
        }

        synchronized (DoubleCheckedLocking.class) {
            if (null == instance) {
                instance = new DoubleCheckedLocking();
                /**
                 * 1、开辟空间2、初始化对象3、返回对象的地址给引用
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
