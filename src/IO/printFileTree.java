package IO;

import java.io.File;
//ʹ�õݹ��㷨��ӡĿ¼
public class printFileTree {
	public static void main(String[] args) {
		File file = new File("F:\\Multifunctionapplication\\�γ�����\\�����һѧ�ڿ�Ŀ����");
		printFile(file, 0);
	}

	public static void printFile(File file, int level) {
		// �������
		for (int i = 0; i < level; i++) {
			System.out.print("-");
		}

		System.out.println(file.getName());
		if (file.isDirectory()) {
			File files[] = file.listFiles();
			for (File temp : files) {
				printFile(temp, level + 1);
			}
		}
	}
}
