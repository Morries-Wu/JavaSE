package Thread;

//isAlive:线程是否还活着
//Thread.currenThread():当前线程
//setName、getName：名称
public class OtherThread {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().isAlive());
		// 设置名称:真实角色+代理角色
		MyOtherThread info = new MyOtherThread("战斗机");
		Thread t = new Thread(info);
		t.setName("公鸡");
		t.start();
		t.sleep(1000);
		System.out.println(t.isAlive());
	}
}

class MyOtherThread implements Runnable {
	private String name;

	public MyOtherThread(String name) {
		this.name = name;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + "    " + name);
	}

}