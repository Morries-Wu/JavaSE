package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
����������:������
Ŀ��:ʹ�ö��߳�ʵ�ֶ���ͻ����������շ�������Ϣ
����:1������̫�಻��ά����2���ͻ��˶�дû�зֿ�������д���
*/
public class MultiServer03 {
	public static void main(String[] args) throws IOException {
		// 1.ָ���˿� ʹ��SeverSocket����������
		System.out.println("----------------Sever-----------");
		ServerSocket server = new ServerSocket(8888);
		// 2.����ʽ �ȴ�����accept
		while (true) {
			Socket client = server.accept();
			System.out.println("һ���ͻ��˽���������");

			new Thread(() -> {
				DataInputStream dis = null;
				DataOutputStream dos = null;
				boolean isRunning = true;
				try {
					dis = new DataInputStream(client.getInputStream());
					dos = new DataOutputStream(client.getOutputStream());
					while (isRunning) {
						// 3.������Ϣ
						String msg = dis.readUTF();

						// 4.������Ϣ
						dos.writeUTF(msg);
						dos.flush();
					}

				} catch (IOException e) {
				 //e.printStackTrace();
					isRunning=false;
				}

				// 4.�ͷ���Դ
				try {
					if (dos != null) {
						dos.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				try {
					if (dis != null) {
						dis.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				try {
					if (client != null) {
						client.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}).start();

		}

	}
}
