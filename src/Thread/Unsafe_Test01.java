package Thread;
//�̲߳���ȫ:�����и���,��ͬ
public class Unsafe_Test01 {
	public static void main(String[] args) {
		// һ����Դ�������
		UnsafeWeb12306 web = new UnsafeWeb12306();
		System.out.println("�߳�����:" + Thread.currentThread().getName());
		new Thread(web, "���").start();
		new Thread(web, "����").start();
		new Thread(web, "sim").start();

	}
}

class UnsafeWeb12306 implements Runnable {
	// Ʊ��
	private int ticketNums = 100;
	private boolean flag = true;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			test();
		}
	}

	public void test() {
		if (ticketNums < 0) {
			flag = false;
			return;
		}
		// sleepΪʲôʹ��try catch,��Ϊrun�����ǲ��ܶ���Throws,ͬʱrun����û�з���ֵ
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�߳�����:" + Thread.currentThread().getName() + "---" + ticketNums--);
	}

}
