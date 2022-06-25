package Thread;

//模拟龟兔赛跑
public class Sleep_Test01 implements Runnable {
	private String winner;

	@Override
	public void run() {
		for (int setps = 1; setps <= 100; setps++) {
			// 模拟休息
			if (Thread.currentThread().getName().equals("兔子") && setps % 10 == 0) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + ":走了" + setps);
			// 比赛是否结束
			boolean flag = gameOver(setps);
			if (flag == true)
				break;
		}
	}

	private boolean gameOver(int setps) {
		if (winner != null) {
			// 存在胜利者
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
		new Thread(sleep_Test01, "乌龟").start();
		new Thread(sleep_Test01, "兔子").start();
	}
}
