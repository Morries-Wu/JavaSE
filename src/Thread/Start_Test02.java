package Thread;


//�̴߳�����ʽ��:
//�Ƽ�:���ⵥ�̳еľ�����,����ʹ�ýӿ�
//���㹲����Դ
public class Start_Test02 implements Runnable {

	// �߳���ڵ�
	public void run() {
		// ���߳����������ǿ���д���ǵĴ���Ҳ����д�����ĵ���
		for (int i = 0; i < 20; i++) {
			System.out.println("һ������һ�ߴ����");
		}
	}

	public static void main(String[] args) {
		// �����̴߳���ʵ�������
		// StartRun sr = new StartRun();
		// �������������
		// Thread t = new Thread(sr);
		// t.start();

		new Thread(new Start_Test02()).start();
		for (int i = 0; i < 20; i++) {
			System.out.println("һ�ߴ���һ��ϴͷ");
		}

	}
}
