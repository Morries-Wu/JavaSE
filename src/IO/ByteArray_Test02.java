package IO;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

//�ֽ�����������
//1.����Դ
//2.ѡ����
//3.����
//4.�ͷ���Դ
//ǿ�����ǲ���IO����ʱ���ȡ���ݵ�ʱ�������ǲ���ֱ�Ӳ����ļ��еģ�������ļ���������Ҫ���õ��ݹ�
public class ByteArray_Test02 {
	public static void main(String[] args) {

		// 1.����Դ
		byte src[] = "talk is cheap show me the code".getBytes();
		InputStream is = null;
		// 2.ѡ��������ȡ��������������
		try {
			is = new ByteArrayInputStream(src);
			// 3.�����ֶζ�ȡ
			byte flush[] = new byte[1024];// ��������
			int len = -1;// ���ܳ���
			while ((len = is.read(flush)) != -1) {
				// �ֽ�����->�ַ���(����)
				String str = new String(flush, 0, len);
				System.out.println(str);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 4.�ͷ���Դ
			try {
				if (is != null) {// �˴�����Ϊis���õ����ļ������Źر�������û�е��õ��ļ�����is���ǿ������is.close����ֿ�ָ���쳣
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
