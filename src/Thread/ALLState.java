package Thread;

import java.lang.Thread.State;

//�۲��̵߳�״̬
public class ALLState {
	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("....");
			}
		});
		// �۲�״̬
		State state = t.getState();
		System.out.println(state);// NEW

		t.start();
		state = t.getState();// RUNNABLE
		System.out.println(state);

//		while (state != Thread.State.TERMINATED) {
//			try {
//				Thread.sleep(200);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			state = t.getState();// TIMED_WAITING
//			System.out.println(state);
//		}

		while (true) {
			int num = Thread.activeCount();//��߳���
			System.out.println(num);
			if (num == 1) {
				break;
			}
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
			state = t.getState();// TIMED_WAITING
			System.out.println(state);
		}

//		state = t.getState();
//		System.out.println(state);// TERMINATED

	}
}
