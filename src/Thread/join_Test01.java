package Thread;

//join�ϲ��߳�,�����߳�ִ����ɺ�,��ִ�������߳�,�����߳�����
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
					t.join();//���main������
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("main.....");
		}
	}
}
