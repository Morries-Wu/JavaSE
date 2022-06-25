package Thread;

//Э��ģ��:������������ʵ�ַ�ʽ��:�źŵƷ�
//������־λ
public class Cooperation_Test02 {
	public static void main(String[] args) {
		TV container = new TV();
		new Player(container).start();
		new Watcher(container).start();
	}
}

//������ ��Ա
class Player extends Thread {
	TV tv;

	public Player(TV tv) {
		this.tv = tv;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if (i % 2 == 0) {
				this.tv.play("����˵");
			} else {
				this.tv.play("̫����,��ƿ����ϴϴ��");
			}
		}
	}
}

//������ ����
class Watcher extends Thread {
	TV tv;

	public Watcher(TV tv) {
		this.tv = tv;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			tv.watch();
		}
	}
}

//ͬһ��Դ  ����
class TV {
	String voice;
	// �źŵ�
	// T ��ʾ��Ա���� ���ڵȴ�
	// F ��ʾ���ڹۿ� ��Ա�ȴ�
	boolean flag = true;

	// ����
	public synchronized void play(String voice) {
		// ��Ա�ȴ�
		if (flag != true) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// ����
		System.out.println("������:" + voice);
		this.voice = voice;
		// ����
		this.notifyAll();
		this.flag = !this.flag;
	}

	// �ۿ�
	public synchronized void watch() {
		if (flag == true) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("������:" + voice);
		// ����
		this.notifyAll();
		//�л���־
		this.flag = !this.flag;
	}
}
