package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

//面向对象思想封装 分割
public class SplitFile {
	// 源头
	private File src;
	// 目的地的(文件夾)
	private String destDir;
	// 所有分割后的文件存储路径
	private List<String> destPaths;
	// 每块大小
	private int blockSize;
	// 快数:多少块
	private int size;

	public SplitFile() {
	}

	public SplitFile(String srcPath, String destDir, int blockSize) {
		this.src = new File(srcPath);
		this.destDir = destDir;
		this.blockSize = blockSize;
		this.destPaths = new ArrayList<String>();
		this.init();
	}

	// 初始化
	private void init() {
		// 总长度
		long len = src.length();
		// 块数:多少块
		this.size = (int) Math.ceil(len * 1.0 / blockSize);//1024
		// 路径
		for (int i = 0; i < size; i++) {
			this.destPaths.add(this.destDir + "/" + i + "-" + this.src.getName());
		}
	}

	// 分割
	// 1、计算每一块的起始位置及大小
	private void split() throws IOException {
		// 总长度
		long len = src.length();
		// 起始位置和实际大小
		int beginPos = 0;
		int actualSize = (int) (blockSize > len ? len : blockSize);
		for (int i = 0; i < size; i++) {
			beginPos = i * blockSize;
			if (i == size - 1) {// 最后一块
				actualSize = (int) len;
			} else {
				actualSize = blockSize;
				len = len - actualSize;// 剩余量
			}
			splitDetail(i, beginPos, actualSize);
		}
	}

	private void splitDetail(int i, int beginPos, int actualSize) throws IOException {
		RandomAccessFile in = new RandomAccessFile(this.src, "r");
		RandomAccessFile out = new RandomAccessFile(this.destPaths.get(i), "rw");
		// 随机读取
		in.seek(beginPos);
		// 操作(分段读取)
		byte flush[] = new byte[1024];
		int len = -1; // 接收长度
		while ((len = in.read(flush)) != -1) {
			if (actualSize > len) {
				// 获取本次读取的所有内容
				actualSize = actualSize - len;
				out.write(flush, 0, len);
			} else {
				out.write(flush, 0, actualSize);
				break;
			}
		}
		out.close();
		in.close();
	}

	// 文件合并
	public void merge01(String destPath) throws IOException {
		// 输出流
		OutputStream out = new BufferedOutputStream(new FileOutputStream(destPath, true));
		// 输入流
		for (int i = 0; i < destPaths.size(); i++) {
			InputStream in = new BufferedInputStream(new FileInputStream(destPaths.get(i)));
			// 拷贝
			// 操作(分段读取)
			byte flush[] = new byte[1024];// 缓冲容器
			int len = -1;// 接收长度
			while ((len = in.read(flush)) != -1) {
				out.write(flush, 0, len);
			}
			out.flush();
			in.close();
		}
		out.close();
	}

	public void merge02(String destPath) throws IOException {
		// 输出流
		OutputStream out = new BufferedOutputStream(new FileOutputStream(destPath, true));
		// 输入流
		SequenceInputStream sin = null;
		Vector<InputStream> vi = new Vector<InputStream>();
		for (int i = 0; i < destPaths.size(); i++) {
			vi.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));
			// 拷贝
			// 操作(分段读取)
		}
		sin = new SequenceInputStream(vi.elements());
		byte flush[] = new byte[1024];// 缓冲容器
		int len = -1;// 接收长度
		while ((len = sin.read(flush)) != -1) {
			out.write(flush, 0, len);
		}
		out.flush();
		sin.close();
		out.close();
	}

	public static void main(String[] args) throws IOException {
		SplitFile SF = new SplitFile(
				"F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice\\jAVA300\\IO\\SplitFile.java",
				"dest", 1024);
		SF.split();
		SF.merge01("copy.java");
	}
}
