package Network;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/*
ģ���¼ ˫��
�����ͻ���
1.��������:ʹ��Socket�����ͻ���+����ĵ�ַ�Ͷ˿�
2.����:�������������
3.�ͷ���Դ
*/
public class LoginMultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("----------------Client-----------");
		// 1.��������:ʹ��Socket�����ͻ���+����ĵ�ַ�Ͷ˿�
		Socket client = new Socket("localhost", 8888);

		// 2.����:���������
		new Send(client).send();
		new Receive(client).receive();
		client.close();
	}

	// ����
	static class Send {
		private DataOutputStream dos;
		private Socket client;
		private BufferedReader console;
		private String msg;

		public Send(Socket client) {
			console = new BufferedReader(new InputStreamReader(System.in));
			this.msg = init();
			this.client = client;
			try {
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void send() {
			try {
				dos.writeUTF(this.msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private String init() {
			System.out.println("�������û���");
			try {
				String uname = console.readLine();
				System.out.println("����������");
				String upwd = console.readLine();
				return "uname=" + uname + "&" + "upwd=" + upwd;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "";
		}

	}

	// ����
	static class Receive {
		DataInputStream dis;
		private Socket client;

		public Receive(Socket client) {
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void receive() {
			String result;
			try {
				result = dis.readUTF();
				System.out.println(result);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
