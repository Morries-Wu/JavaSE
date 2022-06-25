package IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

//文件字符输出流 加入缓冲流
public class Buffered_Test04 {
	public static void main(String[] args) {
		// 1.创建源
		File dest = new File("src\\OutFile\\dest.txt");
		// 2.创建流

		try (BufferedWriter out = new BufferedWriter(new FileWriter(dest));) {
			// 3.操作
			out.append("IO very laji");
			out.newLine();

			out.append("eclipse forever god");
			out.newLine();
			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
