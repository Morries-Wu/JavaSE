package Thread;

//一个资源有多个代理,去操作这里就是我们说的并发了
//共享资源(线程安全)
public class Sleep_Test02 implements Runnable {
	// 票数
	private int ticketNums = 99;

	@Override
	public void run() {
		while (true) {
			if (ticketNums < 0) {
				break;
			}
			// sleep为什么使用try catch,因为run方法是不能对外Throws,同时run方法没有返回值
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("线程名字:" + Thread.currentThread().getName() +"||"+ ticketNums--);
		}
	}

	public static void main(String[] args) {
		// 一份资源多个代理
		Sleep_Test02 web = new Sleep_Test02();
		System.out.println("线程名字:" + Thread.currentThread().getName());
		new Thread(web, "蚂蟥").start();
		new Thread(web, "狗哥").start();
		new Thread(web, "sim").start();
	}
}
