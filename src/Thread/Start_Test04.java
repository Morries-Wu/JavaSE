package Thread;

import java.util.Iterator;

//�̴߳�����ʽһ:
//1������:�̳�Thread+��дrun
//2������:�����������+start
public class Start_Test04 extends Thread {

	// �߳���ڵ�
	public void run() {
		// ���߳����������ǿ���д���ǵĴ���Ҳ����д�����ĵ���
		for (int i = 0; i < 20; i++) {
			System.out.println("һ������һ�ߴ����");
		}
	}

	public static void main(String[] args) {
		// �����̴߳����������
		new Start_Test04().start();
		// ������������start����
		//����֤����������CPU����
		//st.run();��ͨ��������
		for (int i = 0; i < 20; i++) {
			System.out.println("һ�ߴ���һ��ϴͷ");
		}
	}
}
