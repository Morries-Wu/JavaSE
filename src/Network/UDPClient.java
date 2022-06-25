package Network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/*
	���Ͷ�
	1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
	2.׼������ һ��Ҫת���ֽ�����
	3.��װ��DatagramPacket����,��Ҫָ��Ŀ�ĵ�
	4.���Ͱ���send(DatagramPacket)
	5.�ͷ���Դ
*/
public class UDPClient {
	public static void main(String[] args) throws Exception {
		System.out.println("���ͷ�������....");
		// 1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
		DatagramSocket client = new DatagramSocket(8888);
		// 2.׼������ һ��Ҫת���ֽ�����
		String data = "��Ҫȥ����";
		byte datas[] = data.getBytes();
		// 3.��װ��DatagramPacket����,��Ҫָ��Ŀ�ĵ�
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
		// 4.���Ͱ���send(DatagramPacket)
		client.send(packet);
		client.close();
	}
}
