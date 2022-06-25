package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//��һ���������������� �ļ��ֽ�������
//1.����Դ
//2.ѡ����
//3.����
//4.�ͷ���Դ
//ǿ�����ǲ���IO����ʱ���ȡ���ݵ�ʱ�������ǲ���ֱ�Ӳ����ļ��еģ�������ļ���������Ҫ���õ��ݹ�
public class InputStream_Test01 {
	public static void main(String[] args) throws IOException {

		// 1.����Դ
		File src = new File("src\\OutFile\\dest.txt");
		InputStream is = null;
		// 2.ѡ��������ȡ��������������
		try {
			is = new FileInputStream(src);
			// 3.����(��ȡ)
			int temp;
			while ((temp = is.read()) != -1) {
				System.out.print((char) temp+"  ");
			}
		} catch (IOException e) {
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
