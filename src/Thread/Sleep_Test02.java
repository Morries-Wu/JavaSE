package Thread;

//һ����Դ�ж������,ȥ���������������˵�Ĳ�����
//������Դ(�̰߳�ȫ)
public class Sleep_Test02 implements Runnable {
	// Ʊ��
	private int ticketNums = 99;

	@Override
	public void run() {
		while (true) {
			if (ticketNums < 0) {
				break;
			}
			// sleepΪʲôʹ��try catch,��Ϊrun�����ǲ��ܶ���Throws,ͬʱrun����û�з���ֵ
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("�߳�����:" + Thread.currentThread().getName() +"||"+ ticketNums--);
		}
	}

	public static void main(String[] args) {
		// һ����Դ�������
		Sleep_Test02 web = new Sleep_Test02();
		System.out.println("�߳�����:" + Thread.currentThread().getName());
		new Thread(web, "���").start();
		new Thread(web, "����").start();
		new Thread(web, "sim").start();
	}
}
