package Network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
//ʵ�ֽ��ն�
//Address already in use:Cannot bind ͬһ��Э���¶˿ڲ������ͻ
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//�ļ��洢:���ն�
//1.ʹ��DatagramSocket ָ���˿� �������ն�
//2.׼������ ��װ��DatagramPacket ����
//3.����ʽ���հ���receive(DatagramPacket)
//4.�������� ���ֽ����黹ԭΪ��Ӧ�����ͼ���	
//5.�ͷ���Դ

public class UDPFileServer {
	public static void main(String[] args) throws Exception {
		System.out.println("���շ�������");
		// 1.ʹ��DatagramSocket ָ���˿� �������ն�
		DatagramSocket server = new DatagramSocket(9999);
		// 2.׼������ ��װ��DatagramPacket ����
		byte container[] = new byte[1024];
		DatagramPacket packet = new DatagramPacket(container, 0, container.length);

		// 3.����ʽ���հ���receive(DatagramPacket)
		server.receive(packet);
		byte datas[] = packet.getData();
		int len = packet.getLength();
		IOUtil.byteArrayToFile(datas, "copy_next.jpg");
		server.close();
	}
}
