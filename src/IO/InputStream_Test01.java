package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//第一个程序：理解操作步骤 文件字节输入流
//1.创建源
//2.选择流
//3.操作
//4.释放资源
//强调我们操作IO流的时候读取内容的时候我们是不能直接操作文件夹的，想操作文件夹我们需要调用到递归
public class InputStream_Test01 {
	public static void main(String[] args) throws IOException {

		// 1.创建源
		File src = new File("src\\OutFile\\dest.txt");
		InputStream is = null;
		// 2.选择流【读取流还是输入流】
		try {
			is = new FileInputStream(src);
			// 3.操作(读取)
			int temp;
			while ((temp = is.read()) != -1) {
				System.out.print((char) temp+"  ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4.释放资源
			try {
				if (is != null) {// 此处是因为is调用到了文件操作才关闭流，若没有调用到文件操作is还是空则后续is.close会出现空指针异常
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
