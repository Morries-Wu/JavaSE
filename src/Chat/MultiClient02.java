package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/*
����������:�ͻ���
Ŀ��:��װʹ�ö��߳�ʵ�ֶ���ͻ����������շ�������Ϣ
*/
public class MultiClient02 {
	public static void main(String[] args) throws IOException {
		System.out.println("----------------Client-----------");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�������û���");
		// 1.��������:ʹ��Socket�����ͻ���+����ĵ�ַ�Ͷ˿�
		Socket client = new Socket("localhost", 8888);
		new Thread(new Send(client, in.readLine())).start();
		new Thread(new Receive(client)).start();
	}
}
