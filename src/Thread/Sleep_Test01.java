package Thread;

//ģ���������
public class Sleep_Test01 implements Runnable {
	private String winner;

	@Override
	public void run() {
		for (int setps = 1; setps <= 100; setps++) {
			// ģ����Ϣ
			if (Thread.currentThread().getName().equals("����") && setps % 10 == 0) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + ":����" + setps);
			// �����Ƿ����
			boolean flag = gameOver(setps);
			if (flag == true)
				break;
		}
	}

	private boolean gameOver(int setps) {
		if (winner != null) {
			// ����ʤ����
			return true;
		} else {
			if (setps == 100) {
				winner = Thread.currentThread().getName();
				System.out.println("Winner:" + winner);
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Sleep_Test01 sleep_Test01 = new Sleep_Test01();
		new Thread(sleep_Test01, "�ڹ�").start();
		new Thread(sleep_Test01, "����").start();
	}
}
