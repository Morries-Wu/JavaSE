package Exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//使用try-catch捕获异常
public class Test03 {
	public static void main(String[] args) {
		FileReader reader = null;
		try {
			reader = new FileReader("abc.txt");
			System.out.println("step1");
			byte flush[]=new byte[1024];
			int out =  reader.read();
			System.out.println(out);
			// 往文件里读一个字符

		} catch (FileNotFoundException e) {// 子类异常对象异常在前，父类异常在后
			System.out.println("step2");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("step3");
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
