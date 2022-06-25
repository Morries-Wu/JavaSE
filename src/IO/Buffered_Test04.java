package IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

//�ļ��ַ������ ���뻺����
public class Buffered_Test04 {
	public static void main(String[] args) {
		// 1.����Դ
		File dest = new File("src\\OutFile\\dest.txt");
		// 2.������

		try (BufferedWriter out = new BufferedWriter(new FileWriter(dest));) {
			// 3.����
			out.append("IO very laji");
			out.newLine();

			out.append("eclipse forever god");
			out.newLine();
			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
