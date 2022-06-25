package IO;

import java.io.File;
//使用递归算法打印目录
public class printFileTree {
	public static void main(String[] args) {
		File file = new File("F:\\Multifunctionapplication\\课程资料\\大二第一学期科目资料");
		printFile(file, 0);
	}

	public static void printFile(File file, int level) {
		// 输出层数
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
