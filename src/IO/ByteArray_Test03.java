package IO;

import java.io.*;

//�ֽ����������
//1.����Դ
//2.ѡ����
//3.����(д������)
//4.�ͷ���Դ
public class ByteArray_Test03 {
	public static void main(String[] args) {
		// 1.����Դ
		byte dest[] = null;
		// 2.ѡ��Դ
		ByteArrayOutputStream os = null;
		try {
			os = new ByteArrayOutputStream();
			// 3.����(д��)
			String msg = "IO is so easy\r\n";
			byte dates[] = msg.getBytes();// �ַ���->�ַ�����(����)
			os.write(dates, 0, dates.length);
			os.flush();
			//��ȡ����
			dest = os.toByteArray();
			System.out.println(dest.length + "  " + new String(dest, 0, dest.length));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
}
