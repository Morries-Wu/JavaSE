package Network;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


/*
��������:���Ͷ�
1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
2.���������� ת���ֽ�����
3.��װ��DatagramPacket����,��Ҫָ��Ŀ�ĵ�
4.���Ͱ���send(DatagramPacket)
5.�ͷ���Դ
*/
public class UDPObjClient {
	public static void main(String[] args) throws Exception {
		System.out.println("���ͷ�������....");
		// 1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
		DatagramSocket client = new DatagramSocket(8888);
		// 2.׼������ һ��Ҫת���ֽ�����
		// д��
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(baos));
		// ������������+����
		out.writeUTF("����̫����");
		out.writeInt(18);
		out.writeBoolean(false);
		Employee emp = new Employee("����", 66666);
		out.writeObject(emp);
		out.flush();
		byte datas[] = baos.toByteArray();
		// 3.��װ��DatagramPacket����,��Ҫָ��Ŀ�ĵ�
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
		// 4.���Ͱ���send(DatagramPacket)
		client.send(packet);
		client.close();
	}
}
