package IO;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

/**
 * 四个步骤：分段读取文件字符输入流
 * 
 * @author Morries 1、创建源 2、选择流 3、操作 4、
 */
public class ReaderTest {
	public static void main(String[] args) {

		// 1、创建源
		File src = new File("dest.txt");
		// 2、选择流
		Reader reader = null;
		try {
			reader = new FileReader(src);
			// 3.操作(分段读取)
			char flush[] = new char[1024];// 缓冲容器
			int len = -1;// 接受长度
			while ((len = reader.read(flush)) != -1) {
				// 字符数组->字符串(解码)
				String str = new String(flush, 0, len);
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
