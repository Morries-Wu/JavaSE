package Manger;

import java.io.*;

public class FileReaderorWriter {
	public static void objectToFile(Object obj, String outputFile) {
		ObjectOutputStream out = null;
		try {
			/**BufferedOutputStream是一种写入内存信息的缓冲器类,文件相当于一辆货车的货物,缓冲器每次只能装载一定的货物
			 * FileOutputStream类就是要把数据以文件的形式写出到文件中,outputFile就是文件定义的名字Student.txt
			 * 把数据写到Student.txt中
			 * ObjectOutputStream是以对象的形式写进去缓冲器类,然后缓冲器再转换为文件形式写进去Student.txt文件
			 */
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(outputFile)));
			out.writeObject(obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}

	public static Object FileToObject(String filename) {
		ObjectInputStream in = null;
		try {
			/**
			 * BufferedInputStream就是一个读取数据的缓冲器类,FileInputStream把文件的数据读取到内存中的类
			 * ObjectInputStream把内存中的数据读取给自己这个类,然后利用readObject()函数把数据读取给一个Object[ArrayList<Person>]
			 * 然后把读取的数据传送给指定目标
			 */
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));
			Object object = in.readObject();
			return object;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		//如果文件里面一个信息都没有就直接返回个null,说明文件是空的
		return null;
	}
}