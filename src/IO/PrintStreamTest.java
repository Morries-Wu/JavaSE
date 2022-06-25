package IO;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

//打印流PrintStream
public class PrintStreamTest {
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream print = System.out;

		print = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")));
		print.println("打印流");
		print.println(true);
		System.setOut(print);
		System.out.println("change");
		// 重定向输出端

		// 重定向回控制台
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)), true));
		System.out.println("back");
		print.flush();
		print.close();
	}
}
