package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
����������:������
Ŀ��:ʵ�ֶ���ͻ����������շ�������Ϣ
����:�����û�����ȴ�֮ǰ�Ŀͻ��˳�,���ܼ����Ŷ�
*/
public class MultiServer02 {
	public static void main(String[] args) throws IOException {
		// 1.ָ���˿� ʹ��SeverSocket����������
		System.out.println("----------------Sever-----------");
		ServerSocket server = new ServerSocket(8888);
		// 2.����ʽ �ȴ�����accept
		while (true) {
			Socket client = server.accept();
			System.out.println("һ���ͻ��˽���������");

			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			boolean isRunning = true;

			while (isRunning) {
				// 3.������Ϣ
				String msg = dis.readUTF();

				// 4.������Ϣ
				dos.writeUTF(msg);
				dos.flush();
			}
			// 4.�ͷ���Դ
			dos.close();
			dis.close();
			client.close();
		}
	}
}
