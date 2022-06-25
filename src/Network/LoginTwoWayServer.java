package Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
ģ���¼ ˫��
����������
1.ָ���˿� ʹ��SeverSocket����������
2.����ʽ �ȴ�����accept
3.����:�������������
4.�ͷ���Դ
*/
public class LoginTwoWayServer {
	public static void main(String[] args) throws IOException {
		// 1.ָ���˿� ʹ��SeverSocket����������
		System.out.println("----------------Sever-----------");
		ServerSocket server = new ServerSocket(8888);
		// 2.����ʽ �ȴ�����accept
		Socket client = server.accept();
		System.out.println("һ���ͻ��˽���������");
		// 3.����:�������������
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String datas = dis.readUTF();
		String uname = "";
		String upwd = "";
		// ����
		String dataArray[] = datas.split("&");
		for (String info : dataArray) {
			String user[] = info.split("=");
			if (user[0].equals("uname")) {
				System.out.println("����û���Ϊ:" + user[1]);
				uname = user[1];
			} else if (user[0].equals("upwd")) {
				System.out.println("�������Ϊ:" + user[1]);
				upwd = user[1];
			}
		}

		// ���
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		if (uname.equals("10086") && upwd.equals("110")) {
			dos.writeUTF("��¼�ɹ�,��ӭ����");
		} else {
			dos.writeUTF("�û������������");
		}

		// 4.�ͷ���Դ
		dis.close();
		client.close();// �رտͻ�������
		server.close();// �رշ����� }
	}

}
