package Network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/*
ģ���¼ ����
�����ͻ���
1.��������:ʹ��Socket�����ͻ���+����ĵ�ַ�Ͷ˿�
2.����:�������������
3.�ͷ���Դ
*/
public class LoginClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�������û���");
		String uname = console.readLine();
		System.out.println("����������");
		String upwd = console.readLine();

		System.out.println("----------------Client-----------");
		// 1.��������:ʹ��Socket�����ͻ���+����ĵ�ַ�Ͷ˿�
		Socket client = new Socket("localhost", 8888);
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());

		dos.writeUTF("uname=" + uname + "&" + "upwd=" + upwd);
		dos.flush();
		dos.close();
		client.close();
	}
}
