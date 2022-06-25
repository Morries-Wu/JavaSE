package Network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

//�ϴ�
//�����ͻ���
//1.��������:ʹ��Socket�����ͻ���+����ĵ�ַ�Ͷ˿�
//2.����:�������������
//3.�ͷ���Դ
public class FileClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("----------------Client-----------");
		// 1.��������:ʹ��Socket�����ͻ���+����ĵ�ַ�Ͷ˿�
		Socket client = new Socket("localhost", 8888);
		// 2.����:�ļ����� �ϴ�
		InputStream in = new BufferedInputStream(new FileInputStream(
				"F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice\\img\\����.png"));
		OutputStream out = new BufferedOutputStream(client.getOutputStream());
		byte flush[] = new byte[1024];
		int len = -1;
		while ((len = in.read(flush)) != -1) {
			out.write(flush, 0, len);
		}
		out.flush();	
		out.close();
		client.close();
	}
}
