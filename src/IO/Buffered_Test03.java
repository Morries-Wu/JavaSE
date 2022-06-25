package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

/**
 * �ĸ����裺�ֶζ�ȡ�ļ��ַ�������
 * 
 * @author Morries 1������Դ 2��ѡ���� 3������ 4��
 */
public class Buffered_Test03 {
	public static void main(String[] args) {

		// 1������Դ
		File src = new File("dest.txt");
		// 2��ѡ����
		try (BufferedReader reader = new BufferedReader(new FileReader(src));) {
			// 3.����(�ֶζ�ȡ)
			String line = null;
			while ((line = reader.readLine()) != null) {
				// �ַ�����->�ַ���(����)
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
