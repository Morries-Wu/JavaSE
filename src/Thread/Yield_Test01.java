package Thread;

//礼让线程,让当前正在执行线程暂停
//不是阻塞线程，而是将线程从运行状态转入就绪状态
public class Yield_Test01 {

	public static void main(String[] args) {
		MyYield my = new MyYield();
		new Thread(my, "a").start();
		new Thread(my, "b").start();
	}

}

class MyYield implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "-->start");
		Thread.yield();// 礼让
		System.out.println(Thread.currentThread().getName() + "-->end");
	}
}
