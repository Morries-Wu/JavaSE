package IO;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

//文件字符输出流
public class WriterTest {
	public static void main(String[] args) {
		// 1.创建源
		File dest = new File("dest.txt");
		// 2.创建流
		Writer out = null;
		try {
			out = new FileWriter(dest);
			// 3.操作
			// 写法一
			// String msg = "IO is so easy\r\n";
			// char flush[] = msg.toCharArray();// 字符串->字符数组
			// out.write(flush, 0, flush.length);
			// out.flush();

			// 写法二
			// String msg = "IO is so easy\r\n";
			// char flush[] = msg.toCharArray();// 字符串->字符数组
			// out.write(flush);
			// out.flush();

			// 写法三
			out.append("IO is so easy\r\n").append("奥里给");
			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
