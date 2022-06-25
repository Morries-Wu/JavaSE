package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

/**
 * 四个步骤：分段读取文件字符输入流
 * 
 * @author Morries 1、创建源 2、选择流 3、操作 4、
 */
public class Buffered_Test03 {
	public static void main(String[] args) {

		// 1、创建源
		File src = new File("dest.txt");
		// 2、选择流
		try (BufferedReader reader = new BufferedReader(new FileReader(src));) {
			// 3.操作(分段读取)
			String line = null;
			while ((line = reader.readLine()) != null) {
				// 字符数组->字符串(解码)
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
