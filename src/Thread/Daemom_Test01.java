package Thread;

//�ػ��߳�:��Ϊ�û��̷߳����:jvmֹͣ���õȴ��ػ��߳�ִ�����
//Ĭ���û��߳�:jvm�ȴ��û��߳�ִ����ϲ�ֹͣ
public class Daemom_Test01 {
	public static void main(String[] args) {
		God god = new God();
		Com con = new Com();
		Thread t = new Thread(god);
		t.setDaemon(true);// ���û��̵߳���Ϊ�ػ�
		t.start();
		new Thread(con).start();
	}
}

class Com implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i < 365 * 100; i++) {
			System.out.println("happy life..........");
		}
		System.out.println("oooooooo...........");
	}
}

class God implements Runnable {
	@Override
	public void run() {
		while (true) {
			System.out.println("bless you");
		}
	}
}
