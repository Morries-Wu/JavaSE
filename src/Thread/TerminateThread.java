package Thread;

//终止线程
//1、线程正常执行完毕   次数
//2、外部干涉  加入标识位
public class TerminateThread implements Runnable {

	// 加入标识 标记线程体是否可以进行
	private boolean flag = true;
	private String name;

	public TerminateThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		int i = 0;
		// 关联标识, true 运行 false停止
		while (flag) {
			System.out.println(name + ":" + i++);
		}

	}

	// 对外提供方法改变标识
	public void terminate() {
		this.flag = false;
	}

	public static void main(String[] args) {
		TerminateThread tt = new TerminateThread("Mories");
		new Thread(tt).start();
		for (int i = 0; i <= 99; i++) {
			if (i == 88) {
				tt.terminate(); // 线程的终止
				System.out.println("Mories: game over");
			}
			System.out.println("main:" + i);
		}
	}

}
