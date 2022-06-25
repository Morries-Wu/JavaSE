package IO;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


//字节数组输入流
public class ByteArray_Test01 {
	public static void main(String[] args) {
		// 1.创建源
		byte dates[] = "talk is cheap show me the code".getBytes();
		// 2.选择流
		
		InputStream in = null;
		try {
			in = new ByteArrayInputStream(dates);
			// 3.操作
			byte flush[] = new byte[1024];// 缓冲容器
			int len = -1;
			while ((len = in.read(flush)) != -1) {
				// 字节数组->字符串(解码)
				String str = new String(flush, 0, len);
				System.out.println(str); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
