package IO;

import java.io.File;

public class File_Test01 {
	public static void main(String[] args) {
		File src = new File("F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice\\1_169.txt");
		System.out.println(src.getAbsolutePath());
		System.out.println("是否存在：" + src.exists());
		System.out.println("是否是文件：" + src.isFile());
		System.out.println("是否是文件夹" + src.isDirectory());
		System.out.println("___________________________");
		src = new File("1_170.txt");
		System.out.println(src.getAbsolutePath());
		System.out.println("是否存在：" + src.exists());
		System.out.println("是否是文件：" + src.isFile());
		System.out.println("是否是文件夹" + src.isDirectory());
		System.out.println("___________________________");
		src = new File("F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice");
		System.out.println(src.getAbsolutePath());
		System.out.println("是否存在：" + src.exists());
		System.out.println("是否是文件：" + src.isFile());
		System.out.println("是否是文件夹" + src.isDirectory());

		src = new File("xxx");
		if (src.exists() != false) {
			System.out.println("文件不存在");
		} else {
			if (src.isFile()) {
				System.out.println("文件操作");
			} else {
				System.out.println("文件夹操作");
			}
		}
	}
}
