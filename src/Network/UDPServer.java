package Network;
/*
	ʵ�ֽ��ն�
	Address already in use:Cannot bind ͬһ��Э���¶˿ڲ������ͻ
*/
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
	1.ʹ��DatagramSocket ָ���˿� �������ն�
	2.׼������ ��װ��DatagramPacket ����
	3.����ʽ���հ���receive(DatagramPacket)
	4.�������� byte[] getDate()  get Length()
	5.�ͷ���Դ
*/

public class UDPServer {
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
		int len = datas.length;
		System.out.println(len);
		System.out.println(new String(datas, 0, len));
		server.close();
	}
}
