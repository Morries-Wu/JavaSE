package IO;

import java.io.*;

//�ļ��������ļ����������
public class IOCopy {

	public static void main(String[] args) {
		copy("F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice\\img\\close.jpg", "copy.jpg");
	}

	/**
	 * �ļ��Ŀ���
	 * 
	 * @param srcPath
	 * @param destPath
	 */
	public static void copy(String srcPath, String destPath) {
		// 1.����Դ
		File src = new File(srcPath);// Դͷ
		File dest = new File(destPath);// Ŀ�ĵ�
		// 2.ѡ����
		try (InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dest);) {
			// 3.�����ֶζ�ȡ
			byte flush[] = new byte[1024];// ����������
			int len = -1;// ���ܳ���
			while ((len = in.read(flush)) != -1) {
				out.write(flush, 0, len);
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void copy2(String srcPath, String destPath) {
		// 1.����Դ
		File src = new File(srcPath);// Դͷ
		File dest = new File(destPath);// Ŀ�ĵ�
		// 2.ѡ����

		try (BufferedReader in = new BufferedReader(new FileReader(src));
				BufferedWriter out = new BufferedWriter(new FileWriter(dest));) {
			// 3.�����ֶζ�ȡ
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
