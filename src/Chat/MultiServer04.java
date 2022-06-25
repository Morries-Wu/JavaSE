package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
����������:������
Ŀ��:ʹ�ö��߳�ʵ�ֶ���ͻ����������շ�������Ϣ
Ŀ��:��װʹ�ö��߳�ʵ�ֶ���ͻ����������շ�������Ϣ
*/
public class MultiServer04 {
	public static void main(String[] args) throws IOException {
		// 1.ָ���˿� ʹ��SeverSocket����������
		System.out.println("----------------Sever-----------");
		ServerSocket server = new ServerSocket(8888);
		// 2.����ʽ �ȴ�����accept
		while (true) {
			Socket client = server.accept();
			System.out.println("һ���ͻ��˽���������");
			new Thread(new Channel(client)).start();
		}
	}

	static class Channel implements Runnable {
		private boolean isRunning;
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;

		// һ���ͻ�����һ�����߳�
		public Channel(Socket client) {
			this.client = client;
			this.isRunning = true;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				System.out.println("--------------1------------------");
				release();
			}

		}

		// ������Ϣ
		private String receive() {
			String datas = "";
			try {
				datas = dis.readUTF();
			} catch (IOException e) {
				release();
			}
			return datas;
		}

		// ������Ϣ
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				System.out.println("--------------3------------------");
				release();
			}

		}

		// �ͷ���Դ
		private void release() {
			this.isRunning = false;
			Utils.close(client, dis, dos);
		}

		public void run() {
			while (isRunning) {
				String msg = receive();
				if (msg.equals("") != true) {
					send(msg);
				}
			}

		}

	}

}
