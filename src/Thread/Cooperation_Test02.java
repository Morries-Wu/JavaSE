package Thread;

//协作模型:生产者消费者实现方式二:信号灯法
//借助标志位
public class Cooperation_Test02 {
	public static void main(String[] args) {
		TV container = new TV();
		new Player(container).start();
		new Watcher(container).start();
	}
}

//生产者 演员
class Player extends Thread {
	TV tv;

	public Player(TV tv) {
		this.tv = tv;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if (i % 2 == 0) {
				this.tv.play("奇葩说");
			} else {
				this.tv.play("太污了,喝瓶立白洗洗嘴");
			}
		}
	}
}

//消费者 观众
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

//同一资源  电视
class TV {
	String voice;
	// 信号灯
	// T 表示演员表演 观众等待
	// F 表示观众观看 演员等待
	boolean flag = true;

	// 表演
	public synchronized void play(String voice) {
		// 演员等待
		if (flag != true) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 表演
		System.out.println("表演了:" + voice);
		this.voice = voice;
		// 唤醒
		this.notifyAll();
		this.flag = !this.flag;
	}

	// 观看
	public synchronized void watch() {
		if (flag == true) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("听到了:" + voice);
		// 唤醒
		this.notifyAll();
		//切换标志
		this.flag = !this.flag;
	}
}
