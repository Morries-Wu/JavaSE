package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//Ŀ��:���̼߳���ַ���
public class Server_Test07 {
	private ServerSocket serverSocket;
	private boolean isRunning;

	public static void main(String[] args) {
		Server_Test07 server = new Server_Test07();
		server.start();
	}

	// ��������
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
			isRunning = true;
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("����������ʧ��");
			stop();
		}
	}

	// �������Ӵ���
	public void receive() {

		while (isRunning) {
			try {
				Socket client = serverSocket.accept();
				new Thread(new Dispatcher01(client)).start();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("�ͻ��˴���");
			}
		}
	}

	// ֹͣ����
	public void stop() {
		isRunning = false;
		try {
			this.serverSocket.close();
			System.out.println("��������ֹͣ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
