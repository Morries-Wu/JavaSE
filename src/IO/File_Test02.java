package IO;

//length返回的是文件的字节数
//createNewFile():不存在才创建,存在创建
//delete():删除已经存在的文件

import java.io.File;
import java.io.IOException;

public class File_Test02 {
	public static void main(String[] args) throws IOException {
		File src01 = new File("F:\\Multifunctionapplication\\Advanced Files\\Java Project");
		System.out.println("长度：" + src01.length());

		src01 = new File("F:/Multifunctionapplication/Advanced Files/JavaStudy");
		System.out.println("长度：" + src01.length());

		File src02 = new File("F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice\\io.txt");
		boolean flag = src02.createNewFile();
		System.out.println(flag);
		flag = src02.delete();
		System.out.println(flag);
		System.out.println("---------------------");

		// 不是文件夹，只是创建空的没有后缀名的文件
		src02 = new File("F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice\\iqq");
		flag = src02.createNewFile();
		System.out.println(flag);
		System.out.println("---------------------");
		flag = src02.delete();
		System.out.println(flag);

		// 补充:con com3........操作系统的设备名，不能正确创建
		src02 = new File("F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice\\con");
		flag = src02.createNewFile();
		System.out.println(flag);
	}

}
