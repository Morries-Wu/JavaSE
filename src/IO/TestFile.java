package IO;
//����File���÷�

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestFile {
	public static void main(String[] args) throws IOException {
		File f = new File("D:\\a.txt");
		System.out.println(f);
		f.renameTo(new File("D:/cc.txt"));

		System.out.println(System.getProperty("user.dir"));
		File f2 = new File("F:\\Multifunctionapplication\\Advanced Files");

		System.out.println("File�Ƿ���ڣ�" + f2.exists());
		System.out.println("File�Ƿ���Ŀ¼��" + f2.isDirectory());
		System.out.println("File�Ƿ����ļ���" + f2.isFile());
		System.out.println("File����޸�ʱ�䣺" + new Date(f2.lastModified()));
		System.out.println("File�Ĵ�С��" + f2.length());
		System.out.println("File���ļ�����" + f2.getName());
		System.out.println("File��Ŀ¼·����" + f2.getPath());

	}

}
