package Thread;
//线程安全:在并发时保证数据的正确性、效率尽可能高
//synchronized
//1.同步方法
//2.同步块
public class Syn_Test01 {
	public static void main(String[] args) {
		// 一份资源多个代理
		SafeWeb12306 web = new SafeWeb12306();
		System.out.println("线程名字:" + Thread.currentThread().getName());
		new Thread(web, "蚂蟥").start();
		new Thread(web, "狗哥").start();
		new Thread(web, "sim").start();
	}
}

class SafeWeb12306 implements Runnable {
	// 票数
	private int ticketNums = 10;
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			test();
		}
	}

	//线程安全 同步方法锁定this
	public synchronized void test() {
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
		System.out.println("线程名字:" + Thread.currentThread().getName() + "||" + ticketNums--);
	}
}
