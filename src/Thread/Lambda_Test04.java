package Thread;

public class Lambda_Test04 {
	public static void main(String[] args) {
		new Thread(() -> {
			for (int i = 0; i < 20; i++) {
				System.out.println("һ��ѧϰlambda");
			}
		}).start();

		new Thread(() -> System.out.println("һ�߱���")).start();
	}
}
