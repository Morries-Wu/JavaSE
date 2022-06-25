package Thread;


//线程创建方式一:

public class Start_Test01 extends Thread {

    // 线程入口点
    public void run() {
        // 在线程体里面我们可以写我们的代码也可以写方法的调用
        for (int i = 0; i < 20; i++) {
            System.out.println("边打代码");
        }
    }

    public static void main(String[] args) {
        // 启动线程创建子类对象
        new Start_Test01().start();
        // 调用子类对象的start方法
        //不保证立即运行由CPU调用
        //st.run();普通方法调用
        for (int i = 0; i < 20; i++) {
            System.out.println("一边洗头");
        }
    }
}
