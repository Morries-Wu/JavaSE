package Thread;

//join�ϲ��߳�,�����߳�ִ����ɺ�,��ִ�������߳�,�����߳�����
public class join_Test02 {
	public static void main(String[] args) {
		System.out.println("����Ͷ��Ӵ��͵Ĺ���");
		new mother().start();
	}
}

class mother extends Thread {
	@Override
	public void run() {
		System.out.println("�����보�ˣ�����û����");
		System.out.println("�ö���ȥ����");
		Thread t = new Thread(new son());
		t.start();
		try {
			t.join();//mother������
			System.out.println("����ӹ�����,����Ǯ���˶���");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("�����߁G��,�����ȥ�Ҷ�����");
		}

	}
}

class son extends Thread {
	@Override
	public void run() {
		System.out.println("�ӹ������Ǯ��ȥ��");
		System.out.println("·���и���Ϸ��,����10��");
		for (int i = 1; i <= 10; i++) {
			try {
				System.out.println(i+"���ȥ��....");
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("�Ͻ�����ȥ");
		System.out.println("����һƿ�ϳ�");
	}
}
