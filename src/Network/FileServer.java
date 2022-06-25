package Network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//�洢�ļ�
//����������
//1.ָ���˿� ʹ��SeverSocket����������
//2.����ʽ �ȴ�����accept
//3.����:�������������
//4.�ͷ���Դ
public class FileServer {
	public static void main(String[] args) throws IOException {
		// 1.ָ���˿� ʹ��SeverSocket����������
		System.out.println("----------------Sever-----------");
		ServerSocket server = new ServerSocket(8888);
		// 2.����ʽ �ȴ�����accept
		Socket client = server.accept();
		System.out.println("һ���ͻ��˽���������");
		// 3.����:�ļ����� �洢
		InputStream in = new BufferedInputStream(client.getInputStream());
		OutputStream out = new BufferedOutputStream(new FileOutputStream("ppg.png"));

		byte flush[] = new byte[1024];
		int len = -1;
		while ((len = in.read(flush)) != -1) {
			out.write(flush, 0, len);
		}
		// 4.�ͷ���Դ
		client.close();// �رտͻ�������
		server.close();// �رշ�����
	}
}
