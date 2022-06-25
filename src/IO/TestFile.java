package IO;
//测试File类用法

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

		System.out.println("File是否存在：" + f2.exists());
		System.out.println("File是否是目录：" + f2.isDirectory());
		System.out.println("File是否是文件：" + f2.isFile());
		System.out.println("File最后修改时间：" + new Date(f2.lastModified()));
		System.out.println("File的大小：" + f2.length());
		System.out.println("File的文件名：" + f2.getName());
		System.out.println("File的目录路径：" + f2.getPath());

	}

}
