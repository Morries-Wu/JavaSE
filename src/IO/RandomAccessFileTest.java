package IO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

//�����ȡ��д����RandomAccessFile
public class RandomAccessFileTest {
	public static void main(String[] args) throws IOException {
		// �ֶ��ٿ�
		File src = new File("dest.txt");
		// �ܳ���
		long len = src.length();
		System.out.println(len);
		// ÿ���С
		int blockSize = 1024;
		// ����:���ٿ�
		int size = (int) Math.ceil(len * 1.0 / blockSize);
		System.out.println(size);
		// ��ʼλ�ú�ʵ�ʴ�С
		int beginPos = 0;
		int actualSize = (int) (blockSize > len ? len : blockSize);
		for (int i = 0; i < size; i++) {
			beginPos = i * blockSize;
			System.out.println(beginPos);
			if (i == size - 1) {// ���һ��
				actualSize = (int) len;
			} else {
				actualSize = blockSize;
				len = len - actualSize;// ʣ����
			}
			System.out.println(i + "-->" + beginPos + "-->" + actualSize);
			split(beginPos, actualSize);
		}

	}

	// �ֿ�˼��:��ʼ��ʵ�ʴ�С
	public static void split(int beginPos, int actualSize) throws IOException {
		RandomAccessFile randfile = new RandomAccessFile(new File("dest.txt"), "r");
		// ��ʼλ��
		// int beginPos = 2;
		// ʵ�ʴ�С
		// int actualSize = 1026;
		// �����ȡ
		randfile.seek(beginPos);
		// ����(�ֶζ�ȡ)
		byte flush[] = new byte[20];
		int len = -1; // ���ճ���
		while ((len = randfile.read(flush)) != -1) {
			if (actualSize > len) {
				// ��ȡ���ζ�ȡ����������
				System.out.print(new String(flush, 0, len));
				actualSize = actualSize - len;
			} else {
				System.out.println(new String(flush, 0, actualSize));
				break;
			}
		}
		randfile.close();
	}

	// ָ����ʼλ��,��ȡʣ����������
	public static void test01() throws IOException {
		RandomAccessFile randfile = new RandomAccessFile(new File(
				"F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice\\jAVA300\\IO\\BufferedTest01.java"),
				"r");
		// �����ȡ
		randfile.seek(2);
		// ����(�ֶζ�ȡ)
		byte flush[] = new byte[1024];
		int len = -1; // ���ճ���
		while ((len = randfile.read(flush)) != -1) {
			System.out.println(new String(flush, 0, len));
		}
		randfile.close();
	}

}
