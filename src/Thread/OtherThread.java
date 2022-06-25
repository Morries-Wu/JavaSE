package Thread;

//isAlive:�߳��Ƿ񻹻���
//Thread.currenThread():��ǰ�߳�
//setName��getName������
public class OtherThread {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().isAlive());
		// ��������:��ʵ��ɫ+�����ɫ
		MyOtherThread info = new MyOtherThread("ս����");
		Thread t = new Thread(info);
		t.setName("����");
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