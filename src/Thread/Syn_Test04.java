package Thread;


//�̰߳�ȫ:�ڲ���ʱ��֤���ݵ���ȷ�ԡ�Ч�ʾ����ܸ�
//synchronized
//1.ͬ������
//2.ͬ����
public class Syn_Test04 {
	public static void main(String[] args) throws InterruptedException {
		// һ����Դ�������
		SynWeb12306 web = new SynWeb12306();
		System.out.println("�߳�����:" + Thread.currentThread().getName());
		new Thread(web, "���").start();
		new Thread(web, "����").start();
		new Thread(web, "sim").start();
	}
}

class SynWeb12306 implements Runnable {
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
			test5();
		}
	}

	// �̰߳�ȫ ͬ��
	public synchronized void test1() {
		if (ticketNums < 0) {
			flag = false;
			return;
		}
		// sleepΪʲôʹ��try catch,��Ϊrun�����ǲ��ܶ���Throws,ͬʱrun����û�з���ֵ
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�߳�����:" + Thread.currentThread().getName() + "||" + ticketNums--);
	}

	public void test2() {
		synchronized (this) {
			if (ticketNums < 0) {
				flag = false;
				return;
			}
			// sleepΪʲôʹ��try catch,��Ϊrun�����ǲ��ܶ���Throws,ͬʱrun����û�з���ֵ
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("�߳�����:" + Thread.currentThread().getName() + "||" + ticketNums--);
		}

	}

	// �̲߳���ȫ ��ΪInteger��һ�������,һֱ�ڱ仯���Ի������ͬ������
	// synchronized ��������Ķ����ܱ䣬��Ķ�����������С����,С������Ա�
	public void test3() {
		synchronized ((Integer) ticketNums) {
			if (ticketNums < 0) {
				flag = false;
				return;
			}
			// sleepΪʲôʹ��try catch,��Ϊrun�����ǲ��ܶ���Throws,ͬʱrun����û�з���ֵ
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("�߳�����:" + Thread.currentThread().getName() + "||" + ticketNums--);
		}
	}

	// �̲߳���ȫ
	// �����ʣ��һ��Ʊ��ʱ��a,b,c ���a�õ�Ʊ��a����ʱû�е������޸ı���Ȼ��b����Ҳ������ƱҲȡ����
	// Ȼ��cҲ������ȥ�͵���b,cҲ�õ�Ʊ�ͳ��ִ���
	public void test4() {
		synchronized (this) {
			if (ticketNums < 0) {
				flag = false;
				return;
			}
		}
			// ģ����ʱ
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("�߳�����:" + Thread.currentThread().getName() + "||" + ticketNums--);

	}

	//�̰߳�ȫ:��������������ķ�Χ(����ָ���� ָ����������)
	public void test5() {
		if (ticketNums <= 0) {//����ûƱ
			flag = false;
			return;
		}

		synchronized (this) {
			if (ticketNums <= 0) {//�������һ��Ʊ
				flag = false;
				return;
			}
			// ģ����ʱ
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("�߳�����:" + Thread.currentThread().getName() + "||" + ticketNums--);
		}
	}

}
