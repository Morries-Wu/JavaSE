package IO;

import java.io.*;

//四步骤：分段读取 文件字节输出流
//1.创建源
//2.选择流
//3.操作(写出内容)
//4.释放资源
public class ByteArray_Test04 {
	public static void main(String[] args) {
		// 1.创建源
		File dest = new File("dest.txt");
		// 2.选择源
		OutputStream os = null;
		try {
			os = new FileOutputStream(dest, true);
			// 3.操作(写出)
			String msg = "IO is so easy\r\n";
			byte dates[] = msg.getBytes();// 字符串->字符数组(编码)
			os.write(dates, 0, dates.length);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
