package Exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test02 {

	public static void main(String[] args) {
		FileReader reader = null;
		try {
			reader = new FileReader("abc.txt");
			System.out.println("stpe1");
			char c1 = (char) reader.read();
			System.out.println(c1);
		} catch (FileNotFoundException e) {
			System.out.println("stpe2");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("stpe3");
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
