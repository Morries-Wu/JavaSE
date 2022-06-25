package Server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//Ŀ��:ʹ��ServerSocket�����������������,��ȡ����Э��
public class Server_Test01 {
	private ServerSocket serverSocket;

	public static void main(String[] args) {
		Server_Test01 server = new Server_Test01();
		server.start();
	}

	// ��������
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("����������ʧ��");
		}
	}

	// �������Ӵ���
	public void receive() {
		try {	
			Socket client = serverSocket.accept();
			System.out.println("һ���ͻ��˽���������");
			// ��ȡ����Э��
			InputStream in = client.getInputStream();
			byte datas[] = new byte[1024 * 1024];
			int len = in.read(datas);
			String requestInfo = new String(datas, 0, len);
			System.out.println(requestInfo);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ͻ��˴���");

		}
	}

	// ֹͣ����
	public void stop() {

	}

}
