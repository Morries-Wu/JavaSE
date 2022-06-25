package Thread;


//线程安全:在并发时保证数据的正确性、效率尽可能高
//synchronized
//1.同步方法
//2.同步块
public class Syn_Test04 {
	public static void main(String[] args) throws InterruptedException {
		// 一份资源多个代理
		SynWeb12306 web = new SynWeb12306();
		System.out.println("线程名字:" + Thread.currentThread().getName());
		new Thread(web, "蚂蟥").start();
		new Thread(web, "狗哥").start();
		new Thread(web, "sim").start();
	}
}

class SynWeb12306 implements Runnable {
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
			test5();
		}
	}

	// 线程安全 同步
	public synchronized void test1() {
		if (ticketNums < 0) {
			flag = false;
			return;
		}
		// sleep为什么使用try catch,因为run方法是不能对外Throws,同时run方法没有返回值
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("线程名字:" + Thread.currentThread().getName() + "||" + ticketNums--);
	}

	public void test2() {
		synchronized (this) {
			if (ticketNums < 0) {
				flag = false;
				return;
			}
			// sleep为什么使用try catch,因为run方法是不能对外Throws,同时run方法没有返回值
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("线程名字:" + Thread.currentThread().getName() + "||" + ticketNums--);
		}

	}

	// 线程不安全 因为Integer是一个大对象,一直在变化所以会出现相同的数字
	// synchronized 是锁定大的对象不能变，大的对象里面又有小对象,小对象可以变
	public void test3() {
		synchronized ((Integer) ticketNums) {
			if (ticketNums < 0) {
				flag = false;
				return;
			}
			// sleep为什么使用try catch,因为run方法是不能对外Throws,同时run方法没有返回值
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("线程名字:" + Thread.currentThread().getName() + "||" + ticketNums--);
		}
	}

	// 线程不安全
	// 如果在剩下一张票的时候a,b,c 如果a拿到票了a先延时没有到主存修改变量然后b进来也发现有票也取走了
	// 然后c也进行下去就导致b,c也拿到票就出现错误
	public void test4() {
		synchronized (this) {
			if (ticketNums < 0) {
				flag = false;
				return;
			}
		}
			// 模拟延时
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("线程名字:" + Thread.currentThread().getName() + "||" + ticketNums--);

	}

	//线程安全:尽可能锁定合理的范围(不是指代码 指完整的数据)
	public void test5() {
		if (ticketNums <= 0) {//考虑没票
			flag = false;
			return;
		}

		synchronized (this) {
			if (ticketNums <= 0) {//考虑最后一张票
				flag = false;
				return;
			}
			// 模拟延时
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("线程名字:" + Thread.currentThread().getName() + "||" + ticketNums--);
		}
	}

}
