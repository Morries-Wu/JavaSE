package IO;

import java.io.*;

//字节数组输出流
//1.创建源
//2.选择流
//3.操作(写出内容)
//4.释放资源
public class ByteArray_Test03 {
	public static void main(String[] args) {
		// 1.创建源
		byte dest[] = null;
		// 2.选择源
		ByteArrayOutputStream os = null;
		try {
			os = new ByteArrayOutputStream();
			// 3.操作(写出)
			String msg = "IO is so easy\r\n";
			byte dates[] = msg.getBytes();// 字符串->字符数组(编码)
			os.write(dates, 0, dates.length);
			os.flush();
			//获取数据
			dest = os.toByteArray();
			System.out.println(dest.length + "  " + new String(dest, 0, dest.length));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
}
