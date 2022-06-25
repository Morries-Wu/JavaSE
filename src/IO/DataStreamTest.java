package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//数据流
//1.写出后读取
//2.读取的顺序与写出保持一致
//DataOutputStream
//DataInputStream
public class DataStreamTest {
	public static void main(String[] args) throws IOException {

		// 写出
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(baos));
		// 操作数据类型
		out.writeUTF("写代码我很开心");
		out.writeInt(18);
		out.writeBoolean(false);
		out.writeChar('a');
		out.flush();
		byte datas[] = baos.toByteArray();
		System.out.println(datas.length);
		// 读取
		DataInputStream in = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		// 順序与写出一致
		String msg = in.readUTF();
		int age = in.readInt();
		boolean flag = in.readBoolean();
		char ch = in.readChar();
		System.out.println(flag);

	}
}
