package IO;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

/**
 * �ĸ����裺�ֶζ�ȡ�ļ��ַ�������
 * 
 * @author Morries 1������Դ 2��ѡ���� 3������ 4��
 */
public class ReaderTest {
	public static void main(String[] args) {

		// 1������Դ
		File src = new File("dest.txt");
		// 2��ѡ����
		Reader reader = null;
		try {
			reader = new FileReader(src);
			// 3.����(�ֶζ�ȡ)
			char flush[] = new char[1024];// ��������
			int len = -1;// ���ܳ���
			while ((len = reader.read(flush)) != -1) {
				// �ַ�����->�ַ���(����)
				String str = new String(flush, 0, len);
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
