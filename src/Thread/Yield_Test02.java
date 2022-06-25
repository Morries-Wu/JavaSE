package Thread;

//礼让线程,让当前正在执行线程暂停
//不是阻塞线程，而是将线程从运行状态转入就绪状态
public class Yield_Test02 {

	public static void main(String[] args) {
		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("lambda" + i);
			}
		}).start();

		for (int i = 0; i < 100; i++) {
			if (i % 20 == 0) {
				Thread.yield();
			}
			System.out.println("main.....");
		}
	}
}
