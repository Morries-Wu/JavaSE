package IO;

import java.io.*;

//�Ĳ��裺�ֶζ�ȡ �ļ��ֽ������
//1.����Դ
//2.ѡ����
//3.����(д������)
//4.�ͷ���Դ
public class ByteArray_Test04 {
	public static void main(String[] args) {
		// 1.����Դ
		File dest = new File("dest.txt");
		// 2.ѡ��Դ
		OutputStream os = null;
		try {
			os = new FileOutputStream(dest, true);
			// 3.����(д��)
			String msg = "IO is so easy\r\n";
			byte dates[] = msg.getBytes();// �ַ���->�ַ�����(����)
			os.write(dates, 0, dates.length);
			os.flush();
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
