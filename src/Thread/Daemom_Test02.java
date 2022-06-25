package Thread;

//守护线程:是为用户线程服务的:jvm停止不用等待守护线程执行完毕
//默认用户线程:jvm等待用户线程执行完毕才停止
public class Daemom_Test02 {
	public static void main(String[] args) {
		Coco coco = new Coco();
		GOGO gogo = new GOGO();
		Thread t = new Thread(coco);
		t.setDaemon(true);// 将用户线程调整为守护
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