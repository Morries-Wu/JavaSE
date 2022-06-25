package IO;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


//�ֽ�����������
public class ByteArray_Test01 {
	public static void main(String[] args) {
		// 1.����Դ
		byte dates[] = "talk is cheap show me the code".getBytes();
		// 2.ѡ����
		
		InputStream in = null;
		try {
			in = new ByteArrayInputStream(dates);
			// 3.����
			byte flush[] = new byte[1024];// ��������
			int len = -1;
			while ((len = in.read(flush)) != -1) {
				// �ֽ�����->�ַ���(����)
				String str = new String(flush, 0, len);
				System.out.println(str); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
