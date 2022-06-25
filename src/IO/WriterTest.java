package IO;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

//�ļ��ַ������
public class WriterTest {
	public static void main(String[] args) {
		// 1.����Դ
		File dest = new File("dest.txt");
		// 2.������
		Writer out = null;
		try {
			out = new FileWriter(dest);
			// 3.����
			// д��һ
			// String msg = "IO is so easy\r\n";
			// char flush[] = msg.toCharArray();// �ַ���->�ַ�����
			// out.write(flush, 0, flush.length);
			// out.flush();

			// д����
			// String msg = "IO is so easy\r\n";
			// char flush[] = msg.toCharArray();// �ַ���->�ַ�����
			// out.write(flush);
			// out.flush();

			// д����
			out.append("IO is so easy\r\n").append("�����");
			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
