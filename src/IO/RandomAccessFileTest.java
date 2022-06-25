package IO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

//随机读取和写入流RandomAccessFile
public class RandomAccessFileTest {
	public static void main(String[] args) throws IOException {
		// 分多少块
		File src = new File("dest.txt");
		// 总长度
		long len = src.length();
		System.out.println(len);
		// 每块大小
		int blockSize = 1024;
		// 块数:多少块
		int size = (int) Math.ceil(len * 1.0 / blockSize);
		System.out.println(size);
		// 起始位置和实际大小
		int beginPos = 0;
		int actualSize = (int) (blockSize > len ? len : blockSize);
		for (int i = 0; i < size; i++) {
			beginPos = i * blockSize;
			System.out.println(beginPos);
			if (i == size - 1) {// 最后一块
				actualSize = (int) len;
			} else {
				actualSize = blockSize;
				len = len - actualSize;// 剩余量
			}
			System.out.println(i + "-->" + beginPos + "-->" + actualSize);
			split(beginPos, actualSize);
		}

	}

	// 分块思想:起始、实际大小
	public static void split(int beginPos, int actualSize) throws IOException {
		RandomAccessFile randfile = new RandomAccessFile(new File("dest.txt"), "r");
		// 起始位置
		// int beginPos = 2;
		// 实际大小
		// int actualSize = 1026;
		// 随机读取
		randfile.seek(beginPos);
		// 操作(分段读取)
		byte flush[] = new byte[20];
		int len = -1; // 接收长度
		while ((len = randfile.read(flush)) != -1) {
			if (actualSize > len) {
				// 获取本次读取的所有内容
				System.out.print(new String(flush, 0, len));
				actualSize = actualSize - len;
			} else {
				System.out.println(new String(flush, 0, actualSize));
				break;
			}
		}
		randfile.close();
	}

	// 指定起始位置,读取剩余所有内容
	public static void test01() throws IOException {
		RandomAccessFile randfile = new RandomAccessFile(new File(
				"F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice\\jAVA300\\IO\\BufferedTest01.java"),
				"r");
		// 随机读取
		randfile.seek(2);
		// 操作(分段读取)
		byte flush[] = new byte[1024];
		int len = -1; // 接收长度
		while ((len = randfile.read(flush)) != -1) {
			System.out.println(new String(flush, 0, len));
		}
		randfile.close();
	}

}
