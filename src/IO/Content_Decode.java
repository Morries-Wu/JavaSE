package IO;

import java.io.UnsupportedEncodingException;

//���룺�ֽ�����->�ַ���
public class Content_Decode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg = "��������ʹ��";
		// ���룺�ֽ�����
		byte dates[] = msg.getBytes();// Ĭ��ʹ�ù����ַ���

		// ���룺�ַ���String(byte[] bytes, int offset, int length, String charsetName)
		msg = new String(dates, 0, dates.length, "GBK");
		System.out.println(msg);

		// ���룺
		// 1���ֽ�������
		msg = new String(dates, 0, dates.length - 2, "GBK");
		System.out.println(msg);

		// 2���ַ�����ͳһ
		msg = new String(dates, 0, dates.length, "UTF-8");
		System.out.println(msg);
		
	}
}
