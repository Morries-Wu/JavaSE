package IO;

//length���ص����ļ����ֽ���
//createNewFile():�����ڲŴ���,���ڴ���
//delete():ɾ���Ѿ����ڵ��ļ�

import java.io.File;
import java.io.IOException;

public class File_Test02 {
	public static void main(String[] args) throws IOException {
		File src01 = new File("F:\\Multifunctionapplication\\Advanced Files\\Java Project");
		System.out.println("���ȣ�" + src01.length());

		src01 = new File("F:/Multifunctionapplication/Advanced Files/JavaStudy");
		System.out.println("���ȣ�" + src01.length());

		File src02 = new File("F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice\\io.txt");
		boolean flag = src02.createNewFile();
		System.out.println(flag);
		flag = src02.delete();
		System.out.println(flag);
		System.out.println("---------------------");

		// �����ļ��У�ֻ�Ǵ����յ�û�к�׺�����ļ�
		src02 = new File("F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice\\iqq");
		flag = src02.createNewFile();
		System.out.println(flag);
		System.out.println("---------------------");
		flag = src02.delete();
		System.out.println(flag);

		// ����:con com3........����ϵͳ���豸����������ȷ����
		src02 = new File("F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice\\con");
		flag = src02.createNewFile();
		System.out.println(flag);
	}

}
