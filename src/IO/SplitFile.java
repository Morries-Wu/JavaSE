package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

//�������˼���װ �ָ�
public class SplitFile {
	// Դͷ
	private File src;
	// Ŀ�ĵص�(�ļ��A)
	private String destDir;
	// ���зָ����ļ��洢·��
	private List<String> destPaths;
	// ÿ���С
	private int blockSize;
	// ����:���ٿ�
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

	// ��ʼ��
	private void init() {
		// �ܳ���
		long len = src.length();
		// ����:���ٿ�
		this.size = (int) Math.ceil(len * 1.0 / blockSize);//1024
		// ·��
		for (int i = 0; i < size; i++) {
			this.destPaths.add(this.destDir + "/" + i + "-" + this.src.getName());
		}
	}

	// �ָ�
	// 1������ÿһ�����ʼλ�ü���С
	private void split() throws IOException {
		// �ܳ���
		long len = src.length();
		// ��ʼλ�ú�ʵ�ʴ�С
		int beginPos = 0;
		int actualSize = (int) (blockSize > len ? len : blockSize);
		for (int i = 0; i < size; i++) {
			beginPos = i * blockSize;
			if (i == size - 1) {// ���һ��
				actualSize = (int) len;
			} else {
				actualSize = blockSize;
				len = len - actualSize;// ʣ����
			}
			splitDetail(i, beginPos, actualSize);
		}
	}

	private void splitDetail(int i, int beginPos, int actualSize) throws IOException {
		RandomAccessFile in = new RandomAccessFile(this.src, "r");
		RandomAccessFile out = new RandomAccessFile(this.destPaths.get(i), "rw");
		// �����ȡ
		in.seek(beginPos);
		// ����(�ֶζ�ȡ)
		byte flush[] = new byte[1024];
		int len = -1; // ���ճ���
		while ((len = in.read(flush)) != -1) {
			if (actualSize > len) {
				// ��ȡ���ζ�ȡ����������
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

	// �ļ��ϲ�
	public void merge01(String destPath) throws IOException {
		// �����
		OutputStream out = new BufferedOutputStream(new FileOutputStream(destPath, true));
		// ������
		for (int i = 0; i < destPaths.size(); i++) {
			InputStream in = new BufferedInputStream(new FileInputStream(destPaths.get(i)));
			// ����
			// ����(�ֶζ�ȡ)
			byte flush[] = new byte[1024];// ��������
			int len = -1;// ���ճ���
			while ((len = in.read(flush)) != -1) {
				out.write(flush, 0, len);
			}
			out.flush();
			in.close();
		}
		out.close();
	}

	public void merge02(String destPath) throws IOException {
		// �����
		OutputStream out = new BufferedOutputStream(new FileOutputStream(destPath, true));
		// ������
		SequenceInputStream sin = null;
		Vector<InputStream> vi = new Vector<InputStream>();
		for (int i = 0; i < destPaths.size(); i++) {
			vi.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));
			// ����
			// ����(�ֶζ�ȡ)
		}
		sin = new SequenceInputStream(vi.elements());
		byte flush[] = new byte[1024];// ��������
		int len = -1;// ���ճ���
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
