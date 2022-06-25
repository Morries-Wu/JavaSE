package IO;

import java.io.*;

//加入缓冲流
public class Buffered_Test02 {
	public static void main(String[] args) {

		// 1、创建源
		// 2、选择流
		BufferedOutputStream out = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream("src\\OutFile\\dest.txt"));
			String msg = "IO is so good\r\n";
			byte flush[] = msg.getBytes();
			out.write(flush);
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
