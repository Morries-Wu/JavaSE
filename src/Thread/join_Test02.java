package Thread;

//join合并线程,待此线程执行完成后,再执行其他线程,其他线程阻塞
public class join_Test02 {
	public static void main(String[] args) {
		System.out.println("妈妈和儿子打酱油的故事");
		new mother().start();
	}
}

class mother extends Thread {
	@Override
	public void run() {
		System.out.println("妈妈想炒菜，发现没酱油");
		System.out.println("让儿子去打酱油");
		Thread t = new Thread(new son());
		t.start();
		try {
			t.join();//mother被阻塞
			System.out.println("老妈接过酱油,把零钱给了儿子");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("孩子走丟了,老妈出去找儿子了");
		}

	}
}

class son extends Thread {
	@Override
	public void run() {
		System.out.println("接过老妈的钱出去了");
		System.out.println("路边有个游戏厅,玩了10秒");
		for (int i = 1; i <= 10; i++) {
			try {
				System.out.println(i+"秒过去了....");
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("赶紧打酱油去");
		System.out.println("拿了一瓶老抽");
	}
}
