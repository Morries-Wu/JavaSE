package Thread;

//线程优先级
//1.NORM_PRIORITY 5默认
//2.MIN_PRIORITY  1
//3.MAX_PRIORITY  10
//概率性优先级不代表绝对的先后顺序,优先级只能用数字1-10
public class PriorityTest {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getPriority());
		MyPriority mp = new MyPriority();
		Thread t1 = new Thread(mp,"李宁");
		Thread t2 = new Thread(mp,"回力");
		Thread t3 = new Thread(mp,"安踏");
		Thread t4 = new Thread(mp,"百翠羚");
		Thread t5 = new Thread(mp,"特步");
		Thread t6 = new Thread(mp,"匹克");

		// 设置优先级在启动前
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t4.setPriority(Thread.MIN_PRIORITY);
		t5.setPriority(Thread.MIN_PRIORITY);
		t6.setPriority(Thread.MIN_PRIORITY);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();

	}
}

class MyPriority implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "    " + Thread.currentThread().getPriority());
		Thread.yield();

	}
}