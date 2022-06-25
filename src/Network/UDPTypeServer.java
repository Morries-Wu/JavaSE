package Network;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
/*
ʵ�ֽ��ն�
Address already in use:Cannot bind ͬһ��Э���¶˿ڲ������ͻ
*/
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
��������:���ն�
1.ʹ��DatagramSocket ָ���˿� �������ն�
2.׼������ ��װ��DatagramPacket ����
3.����ʽ���հ���receive(DatagramPacket)
4.�������� ���ֽ����黹ԭΪ��Ӧ�����ͼ���
5.�ͷ���Դ
*/

public class UDPTypeServer {
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
		// ��ȡ
		DataInputStream in = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		// �����д��һ��
		String msg = in.readUTF();
		int age = in.readInt();
		boolean flag = in.readBoolean();
		char ch = in.readChar();
		System.out.println(msg);
		System.out.println(age);
		System.out.println(flag);
		System.out.println(ch);
		server.close();
	}
}
