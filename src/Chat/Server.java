package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
����������:������
Ŀ��:ʵ��һ���ͻ����������շ���Ϣ*/
public class Server {
	public static void main(String[] args) throws IOException {
		// 1.ָ���˿� ʹ��SeverSocket����������
		System.out.println("----------------Sever-----------");
		ServerSocket server = new ServerSocket(8888);
		// 2.����ʽ �ȴ�����accept
		Socket client = server.accept();
		System.out.println("һ���ͻ��˽���������");

		// 3.������Ϣ
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String msg = dis.readUTF();
		//4.������Ϣ
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();


		// 4.�ͷ���Դ
		dos.close();
		dis.close();
		client.close();
	}
}
