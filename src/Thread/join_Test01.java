package Thread;

//join合并线程,待此线程执行完成后,再执行其他线程,其他线程阻塞
public class join_Test01 {
	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("lambda" + i);
			}
		});
		t.start();

		for (int i = 0; i < 100; i++) {
			if (i ==20) {
				try {
					t.join();//插队main被阻塞
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("main.....");
		}
	}
}
