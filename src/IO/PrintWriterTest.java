package IO;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class PrintWriterTest {
	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream("print.txt")));
		writer.println("´òÓ¡Á÷");
		writer.println(true);
		writer.close();
	}
}
