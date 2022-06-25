package IO;

import java.io.*;

//1.图片读取到字节数组
//2.字节数组写出到文件
public class ByteArray_Test05 {
	public static void main(String[] args) {
		byte src[] = FileToByteArray("src\\OutFile\\dest.txt");
		byteArrayToFile(src, "src\\OutFile\\copy.txt");
	}

	// 1、图片读取到字节数组
	// 2、图片到程序 FileInputStream
	// 3、程序到字节数组 ByteArrayOutputStream
	public static byte[] FileToByteArray(String filePath) {
		// 1、创建源
		File src = new File(filePath);
		// 2、创建流
		InputStream in = null;
		ByteArrayOutputStream baos = null;
		byte dest[] = null;
		try {
			in = new FileInputStream(src);
			baos = new ByteArrayOutputStream();
			// 3、操作(分段读取)
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

	// 1、字节数组写到图片
	// 2、字节数组读到程序 ByteArrayInputStream
	// 3、程序写出数据到文件 FileOutputStream
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
