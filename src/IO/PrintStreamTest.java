package IO;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

//��ӡ��PrintStream
public class PrintStreamTest {
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream print = System.out;

		print = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")));
		print.println("��ӡ��");
		print.println(true);
		System.setOut(print);
		System.out.println("change");
		// �ض��������

		// �ض���ؿ���̨
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)), true));
		System.out.println("back");
		print.flush();
		print.close();
	}
}
