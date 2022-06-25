package Thread;
//�̰߳�ȫ:�ڲ���ʱ��֤���ݵ���ȷ�ԡ�Ч�ʾ����ܸ�
//synchronized
//1.ͬ������
//2.ͬ����
public class Syn_Test01 {
	public static void main(String[] args) {
		// һ����Դ�������
		SafeWeb12306 web = new SafeWeb12306();
		System.out.println("�߳�����:" + Thread.currentThread().getName());
		new Thread(web, "���").start();
		new Thread(web, "����").start();
		new Thread(web, "sim").start();
	}
}

class SafeWeb12306 implements Runnable {
	// Ʊ��
	private int ticketNums = 10;
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			test();
		}
	}

	//�̰߳�ȫ ͬ����������this
	public synchronized void test() {
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
		System.out.println("�߳�����:" + Thread.currentThread().getName() + "||" + ticketNums--);
	}
}
