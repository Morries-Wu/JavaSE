package Thread;


//线程创建方式二:
//推荐:避免单继承的局限性,优先使用接口
//方便共享资源
public class Start_Test02 implements Runnable {

	// 线程入口点
	public void run() {
		// 在线程体里面我们可以写我们的代码也可以写方法的调用
		for (int i = 0; i < 20; i++) {
			System.out.println("一边听歌一边打代码");
		}
	}

	public static void main(String[] args) {
		// 启动线程创建实现类对象
		// StartRun sr = new StartRun();
		// 创建代理类对象
		// Thread t = new Thread(sr);
		// t.start();

		new Thread(new Start_Test02()).start();
		for (int i = 0; i < 20; i++) {
			System.out.println("一边搓澡一边洗头");
		}

	}
}
