package Network;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

//�ļ��ϴ�:���Ͷ�
//1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
//2.���������� ת���ֽ�����
//3.��װ��DatagramPacket����,��Ҫָ��Ŀ�ĵ�
//4.���Ͱ���send(DatagramPacket)
//5.�ͷ���Դ
public class UDPFileClient {
	public static void main(String[] args) throws Exception {
		System.out.println("���ͷ�������....");
		// 1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
		DatagramSocket client = new DatagramSocket(8888);
		// 2.׼������ һ��Ҫת���ֽ�����

		byte datas[] = IOUtil.FileToByteArray(
				"F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice\\img\\close.jpg");
		// 3.��װ��DatagramPacket����,��Ҫָ��Ŀ�ĵ�
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
		// 4.���Ͱ���send(DatagramPacket)
		client.send(packet);
		client.close();
	}
}
