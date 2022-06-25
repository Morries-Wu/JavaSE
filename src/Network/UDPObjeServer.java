package Network;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
/*
ʵ�ֽ��ն�
Address already in use:Cannot bind ͬһ��Э���¶˿ڲ������ͻ
*/
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
������������:���ն�
1.ʹ��DatagramSocket ָ���˿� �������ն�
2.׼������ ��װ��DatagramPacket ����
3.����ʽ���հ���receive(DatagramPacket)
4.�������� ���ֽ����黹ԭΪ��Ӧ�����ͼ���
5.�ͷ���Դ
*/

public class UDPObjeServer {
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
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		String msg = in.readUTF();
		int age = in.readInt();
		boolean flag = in.readBoolean();
		Object employee = in.readObject();

		if (msg instanceof String) {
			String str = (String) msg;
			System.out.println(str);
		}

		System.out.println(age);
		System.out.println(flag);

		if (employee instanceof Employee) {
			Employee empobj = (Employee) employee;
			System.out.println(empobj.getName() +"   "+ empobj.getSalary());
		}
		server.close();
		in.close();
	}
}
