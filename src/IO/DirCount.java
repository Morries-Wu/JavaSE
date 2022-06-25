package IO;

import java.io.File;

//ʹ��������� ͳ���ļ��Ĵ�С
public class DirCount {
	// ��С
	private long len;
	// �ļ���
	private String path;
	// Դͷ
	private File src;
	// �ļ�����
	private int fileSize;
	// �ļ��и���
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

	// ͳ�ƴ�С
	private void count(File src) {
		// ��ȡ��С
		if (src != null && src.exists()) {
			if (src.isFile()) {
				this.fileSize++;
				len = len + src.length();
			} else {// ���Ｖ
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
