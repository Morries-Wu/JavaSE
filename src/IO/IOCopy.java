package IO;

import java.io.*;

//文件拷贝：文件输入输出流
public class IOCopy {

	public static void main(String[] args) {
		copy("F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice\\img\\close.jpg", "copy.jpg");
	}

	/**
	 * 文件的拷贝
	 * 
	 * @param srcPath
	 * @param destPath
	 */
	public static void copy(String srcPath, String destPath) {
		// 1.创建源
		File src = new File(srcPath);// 源头
		File dest = new File(destPath);// 目的地
		// 2.选择流
		try (InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dest);) {
			// 3.操作分段读取
			byte flush[] = new byte[1024];// 容器缓冲器
			int len = -1;// 接受长度
			while ((len = in.read(flush)) != -1) {
				out.write(flush, 0, len);
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void copy2(String srcPath, String destPath) {
		// 1.创建源
		File src = new File(srcPath);// 源头
		File dest = new File(destPath);// 目的地
		// 2.选择流

		try (BufferedReader in = new BufferedReader(new FileReader(src));
				BufferedWriter out = new BufferedWriter(new FileWriter(dest));) {
			// 3.操作分段读取
			String line = null;
			while ((line = in.readLine()) != null) {
				out.append(line);
				out.newLine();
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
