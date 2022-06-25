package IO;

import java.io.UnsupportedEncodingException;

//解码：字节数组->字符串
public class Content_Decode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg = "性命生命使命";
		// 编码：字节数组
		byte dates[] = msg.getBytes();// 默认使用工程字符集

		// 解码：字符串String(byte[] bytes, int offset, int length, String charsetName)
		msg = new String(dates, 0, dates.length, "GBK");
		System.out.println(msg);

		// 乱码：
		// 1、字节数不够
		msg = new String(dates, 0, dates.length - 2, "GBK");
		System.out.println(msg);

		// 2、字符集不统一
		msg = new String(dates, 0, dates.length, "UTF-8");
		System.out.println(msg);
		
	}
}
