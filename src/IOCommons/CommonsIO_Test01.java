package IOCommons;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class CommonsIO_Test01 {
	public static void main(String[] args) {
		// �ļ���С
		long len = FileUtils.sizeOf(new File(
				"F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice\\jAVA300\\IO\\Buffered_Test01.java"));
		System.out.println(len);
		// Ŀ¼��С
		len = FileUtils.sizeOf(new File(
				"F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice\\jAVA300\\IO\\InputStream_Test01.java"));
		System.out.println(len);
	}
}
