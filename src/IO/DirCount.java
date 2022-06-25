package IO;

import java.io.File;

//使用面向对象 统计文件的大小
public class DirCount {
	// 大小
	private long len;
	// 文件夹
	private String path;
	// 源头
	private File src;
	// 文件个数
	private int fileSize;
	// 文件夹个数
	private int dirSize;

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public int getDirSize() {
		return dirSize;
	}

	public void setDirSize(int dirSize) {
		this.dirSize = dirSize;
	}

	public long getLen() {
		return len;
	}

	public void setLen(long len) {
		this.len = len;
	}

	public DirCount(String path) {
		this.path = path;
		this.src = new File(path);
		count(src);
	}

	// 统计大小
	private void count(File src) {
		// 获取大小
		if (src != null && src.exists()) {
			if (src.isFile()) {
				this.fileSize++;
				len = len + src.length();
			} else {// 子孙级
				this.dirSize++;
				for (File temp : src.listFiles()) {
					count(temp);
				}
			}
		}
	}	

	public static void main(String[] args) {
		DirCount dir = new DirCount("F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice");
		System.out.println(dir.getFileSize());
		System.out.println(dir.getLen());
	}

}
