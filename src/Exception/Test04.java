package Exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//使用throws声明异常
public class Test04 {
	public static void main(String[] args) throws IOException {
		readMyFile();
	}

	public static void readMyFile() throws IOException {

		FileReader reader = null;
		reader = new FileReader("d:/qa.txt");
		System.out.println("step1");
		char c1 = (char) reader.read();
		System.out.println(c1);
		// 往文件里读一个字符
		if (reader != null) {
			reader.close();
		}
	}
}
