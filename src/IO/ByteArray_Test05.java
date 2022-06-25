package IO;

import java.io.*;

//1.ͼƬ��ȡ���ֽ�����
//2.�ֽ�����д�����ļ�
public class ByteArray_Test05 {
	public static void main(String[] args) {
		byte src[] = FileToByteArray("src\\OutFile\\dest.txt");
		byteArrayToFile(src, "src\\OutFile\\copy.txt");
	}

	// 1��ͼƬ��ȡ���ֽ�����
	// 2��ͼƬ������ FileInputStream
	// 3�������ֽ����� ByteArrayOutputStream
	public static byte[] FileToByteArray(String filePath) {
		// 1������Դ
		File src = new File(filePath);
		// 2��������
		InputStream in = null;
		ByteArrayOutputStream baos = null;
		byte dest[] = null;
		try {
			in = new FileInputStream(src);
			baos = new ByteArrayOutputStream();
			// 3������(�ֶζ�ȡ)
			byte flush[] = new byte[1024];
			int len = -1;
			while ((len = in.read(flush)) != -1) {
				baos.write(flush, 0, len);
			}
			baos.flush();
			dest = baos.toByteArray();
			return dest;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (baos != null) {
					baos.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		return null;
	}

	// 1���ֽ�����д��ͼƬ
	// 2���ֽ������������ ByteArrayInputStream
	// 3������д�����ݵ��ļ� FileOutputStream
	public static void byteArrayToFile(byte src[], String filePath) {
		File dest = new File(filePath);
		ByteArrayInputStream in = null;
		OutputStream os = null;
		try {
			in = new ByteArrayInputStream(src);
			os = new FileOutputStream(dest);
			byte flush[] = new byte[1024];
			int len = -1;
			while ((len = in.read(flush)) != -1) {
				os.write(flush, 0, len);
			}
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (os != null) {
					os.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
