package IO;

import java.io.UnsupportedEncodingException;

//�ַ���->�ֽ�[]
public class Content_Encode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg = "��������ʹ��";
		// ���룺�ֽ�����
		byte dates[] = msg.getBytes();// Ĭ��ʹ�ù����ַ���
		System.out.println(dates.length);

		// ���룺�����ַ���
		dates = msg.getBytes("UTF-16LE");
		System.out.println(dates.length);
	}
}
