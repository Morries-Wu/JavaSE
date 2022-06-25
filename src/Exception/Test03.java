package Exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//ʹ��try-catch�����쳣
public class Test03 {
	public static void main(String[] args) {
		FileReader reader = null;
		try {
			reader = new FileReader("abc.txt");
			System.out.println("step1");
			byte flush[]=new byte[1024];
			int out =  reader.read();
			System.out.println(out);
			// ���ļ����һ���ַ�

		} catch (FileNotFoundException e) {// �����쳣�����쳣��ǰ�������쳣�ں�
			System.out.println("step2");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("step3");
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
