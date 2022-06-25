package IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//try...with..resource
public class FileUtil {
	public static void main(String[] args) {

		// 文件到文件
		try {
			InputStream in = new FileInputStream("abc.txt");
			OutputStream out = new FileOutputStream("copy.txt");
			copy(in, out);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 文件到字节数组
		byte datas[] = null;
		try {
			InputStream in = new FileInputStream("abc.txt");
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			copy(in, out);
			datas = out.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 字节数组到文件
		try {
			InputStream in = new ByteArrayInputStream(datas);
			OutputStream out = new FileOutputStream("copy.txt");
			copy(in, out);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void copy(InputStream in, OutputStream out) {
		try {
			byte flush[] = new byte[1024];
			int len = -1;
			while ((len = in.read(flush)) != -1) {
				out.write(flush, 0, len);
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(in, out);
		}
	}

	public static void copy2(InputStream in, OutputStream out) {
		try {
			byte flush[] = new byte[1024];
			int len = -1;
			while ((len = in.read(flush)) != -1) {
				out.write(flush, 0, len);
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static void close(InputStream in, OutputStream out) {
//		try {
//			if (in != null) {
//				in.close();
//			}
//			if (out != null) {
//				out.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public static void close(Closeable... ios) {
		for (Closeable io : ios) {
			try {
				if (io != null) {
					io.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
