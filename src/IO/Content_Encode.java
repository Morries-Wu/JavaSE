package IO;

import java.io.UnsupportedEncodingException;

//字符串->字节[]
public class Content_Encode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg = "性命生命使命";
		// 编码：字节数组
		byte dates[] = msg.getBytes();// 默认使用工程字符集
		System.out.println(dates.length);

		// 编码：其他字符集
		dates = msg.getBytes("UTF-16LE");
		System.out.println(dates.length);
	}
}
