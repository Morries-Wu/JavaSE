package IO;

import java.io.File;

//����Ŀ¼
//mkdir():ȷ���ϼ�Ŀ¼���ڣ������ڴ�����ʧ��
//kdirs():�ϼ�Ŀ¼���Բ����ڣ�������һͬ������
//�г���һ��
//1.list()�г��¼�����
//2.listFiles()�г��¼�File����
//�г������̷�
public class Dir_Demo01 {
	public static void main(String[] args) {
		File dir = new File("F:/Multifunctionapplication/Advanced Files/Java Project/JAVAPratice/dir/test");
		// ����Ŀ¼
		boolean flag = dir.mkdirs();
		System.out.println(flag);

		// �¼�����list
		dir = new File("F:/Multifunctionapplication/Advanced Files/Java Project/.metadata");
		System.out.println(dir.getName());
		String subNames[] = dir.list(); // listֻ����һ���¼�����
		for (String temp : subNames) {
			System.out.println(temp);
		}

		System.out.println("*************************");
		// �¼����� listFile
		File subsFile[] = dir.listFiles();
		for (File temp : subsFile) {
			System.out.println(temp.getName());
		}

		// �����̷�
		File roots[] = dir.listRoots();
		for (File temp : roots) {
			System.out.println(temp.getAbsolutePath());
		}

	}
}
