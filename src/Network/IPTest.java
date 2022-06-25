package Network;

import java.net.InetAddress;
import java.net.UnknownHostException;

//getLocalHost������
//getByName����������DNS|IP

//IP��λһ�����:�������·�ɡ�ͨѶ�豸

//������Ա����
//1.getHostAddress:���ص�ַ
//2.getHostName:���ؼ������
public class IPTest {
	public static void main(String[] args) throws UnknownHostException {

		// ʹ��getLocalHost��������InetAddress����
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());// ����:192.168.1.110
		System.out.println(addr.getHostName() + "\n");// ����������

		// ���������õ�InetAddress����
		addr = InetAddress.getByName("www.shsxt.com");
		System.out.println(addr.getHostAddress());// ����163��������ip:61.135.253.15
		System.out.println(addr.getHostName());// ���:www.163.com

		// DNS��ĳ���ֵ�IP��ַת����������ַ���,���߽��ַ���ӳ��ɶ�Ӧ��IP

		// ����ip�õ�InetAddress����
		addr = InetAddress.getByName("8.136.140.197");
		System.out.println(addr.getHostAddress());// ����163��������ip:123.56.138.176
		System.out.println(addr.getHostName());
		// ���IP����������,������IP��ַ�����ڻ���DNS������������IP��ַ������ӳ��
	}
}
