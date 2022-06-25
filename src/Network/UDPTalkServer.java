package Network;

/*
ʵ�ֽ��ն�
Address already in use:Cannot bind ͬһ��Э���¶˿ڲ������ͻ*/
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
��ν���:���ն�
1.ʹ��DatagramSocket ָ���˿� �������ն�
2.׼������ ��װ��DatagramPacket ����
3.����ʽ���հ���receive(DatagramPacket)
4.�������� byte[] getDate()  get Length()
5.�ͷ���Դ*/

public class UDPTalkServer {
	public static void main(String[] args) throws Exception {
		System.out.println("���շ�������");
		// 1.ʹ��DatagramSocket ָ���˿� �������ն�
		DatagramSocket server = new DatagramSocket(9999);

		while (true) {
			// 2.׼������ ��װ��DatagramPacket ����
			byte container[] = new byte[1024];
			DatagramPacket packet = new DatagramPacket(container, 0, container.length);
			// 3.����ʽ���հ���receive(DatagramPacket)
			server.receive(packet);
			byte datas[] = packet.getData();
			int len = datas.length;
			String data = new String(datas, 0, len);
			System.out.println(data);
			if (data.equals("bye")) {
				break;
			}
		}
		server.close();
	}
}
