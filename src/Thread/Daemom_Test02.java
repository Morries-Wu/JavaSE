package Thread;

//�ػ��߳�:��Ϊ�û��̷߳����:jvmֹͣ���õȴ��ػ��߳�ִ�����
//Ĭ���û��߳�:jvm�ȴ��û��߳�ִ����ϲ�ֹͣ
public class Daemom_Test02 {
	public static void main(String[] args) {
		Coco coco = new Coco();
		GOGO gogo = new GOGO();
		Thread t = new Thread(coco);
		t.setDaemon(true);// ���û��̵߳���Ϊ�ػ�
		t.start();
		new Thread(gogo).start();
	}
}

class Coco implements Runnable {
	public void run() {
		for (int i = 1; i < 365 * 100; i++) {
			System.out.println("happy life..........");
		}
		System.out.println("oooooooo...........");
	}
}

class GOGO implements Runnable {
	public void run() {
		while (true) {
			System.out.println("bless you");
		}
	}
}