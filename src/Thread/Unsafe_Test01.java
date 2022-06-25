package Thread;
//线程不安全:数据有负数,相同
public class Unsafe_Test01 {
	public static void main(String[] args) {
		// 一份资源多个代理
		UnsafeWeb12306 web = new UnsafeWeb12306();
		System.out.println("线程名字:" + Thread.currentThread().getName());
		new Thread(web, "蚂蟥").start();
		new Thread(web, "狗哥").start();
		new Thread(web, "sim").start();

	}
}

class UnsafeWeb12306 implements Runnable {
	// 票数
	private int ticketNums = 100;
	private boolean flag = true;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			test();
		}
	}

	public void test() {
		if (ticketNums < 0) {
			flag = false;
			return;
		}
		// sleep为什么使用try catch,因为run方法是不能对外Throws,同时run方法没有返回值
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("线程名字:" + Thread.currentThread().getName() + "---" + ticketNums--);
	}

}
