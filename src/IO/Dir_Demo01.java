package IO;

import java.io.File;

//创建目录
//mkdir():确保上级目录存在，不存在创建就失败
//kdirs():上级目录可以不存在，不存在一同来创建
//列出下一级
//1.list()列出下级名称
//2.listFiles()列出下级File对象
//列出所有盘符
public class Dir_Demo01 {
	public static void main(String[] args) {
		File dir = new File("F:/Multifunctionapplication/Advanced Files/Java Project/JAVAPratice/dir/test");
		// 创建目录
		boolean flag = dir.mkdirs();
		System.out.println(flag);

		// 下级名称list
		dir = new File("F:/Multifunctionapplication/Advanced Files/Java Project/.metadata");
		System.out.println(dir.getName());
		String subNames[] = dir.list(); // list只返回一层下级名称
		for (String temp : subNames) {
			System.out.println(temp);
		}

		System.out.println("*************************");
		// 下级对象 listFile
		File subsFile[] = dir.listFiles();
		for (File temp : subsFile) {
			System.out.println(temp.getName());
		}

		// 所有盘符
		File roots[] = dir.listRoots();
		for (File temp : roots) {
			System.out.println(temp.getAbsolutePath());
		}

	}
}
