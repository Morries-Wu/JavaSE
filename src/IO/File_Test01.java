package IO;

import java.io.File;

public class File_Test01 {
	public static void main(String[] args) {
		File src = new File("F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice\\1_169.txt");
		System.out.println(src.getAbsolutePath());
		System.out.println("�Ƿ���ڣ�" + src.exists());
		System.out.println("�Ƿ����ļ���" + src.isFile());
		System.out.println("�Ƿ����ļ���" + src.isDirectory());
		System.out.println("___________________________");
		src = new File("1_170.txt");
		System.out.println(src.getAbsolutePath());
		System.out.println("�Ƿ���ڣ�" + src.exists());
		System.out.println("�Ƿ����ļ���" + src.isFile());
		System.out.println("�Ƿ����ļ���" + src.isDirectory());
		System.out.println("___________________________");
		src = new File("F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice");
		System.out.println(src.getAbsolutePath());
		System.out.println("�Ƿ���ڣ�" + src.exists());
		System.out.println("�Ƿ����ļ���" + src.isFile());
		System.out.println("�Ƿ����ļ���" + src.isDirectory());

		src = new File("xxx");
		if (src.exists() != false) {
			System.out.println("�ļ�������");
		} else {
			if (src.isFile()) {
				System.out.println("�ļ�����");
			} else {
				System.out.println("�ļ��в���");
			}
		}
	}
}
