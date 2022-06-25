package Network;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/*
���Ͷ�
1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
2.���������� ת���ֽ�����
3.��װ��DatagramPacket����,��Ҫָ��Ŀ�ĵ�
4.���Ͱ���send(DatagramPacket)
5.�ͷ���Դ
*/

public class UDPTypeClient {
	public static void main(String[] args) throws Exception {
		System.out.println("���ͷ�������....");
		// 1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
		DatagramSocket client = new DatagramSocket(8888);
		// 2.׼������ һ��Ҫת���ֽ�����
		// д��
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(baos));
		// ������������
		out.writeUTF("д�����Һܿ���");
		out.writeInt(18);
		out.writeBoolean(false);
		out.writeChar('a');
		out.flush();
		byte datas[] = baos.toByteArray();
		// 3.��װ��DatagramPacket����,��Ҫָ��Ŀ�ĵ�
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
		// 4.���Ͱ���send(DatagramPacket)
		client.send(packet);
		client.close();
	}
}
