package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//������
//1.д�����ȡ
//2.��ȡ��˳����д������һ��
//DataOutputStream
//DataInputStream
public class DataStreamTest {
	public static void main(String[] args) throws IOException {

		// д��
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(baos));
		// ������������
		out.writeUTF("д�����Һܿ���");
		out.writeInt(18);
		out.writeBoolean(false);
		out.writeChar('a');
		out.flush();
		byte datas[] = baos.toByteArray();
		System.out.println(datas.length);
		// ��ȡ
		DataInputStream in = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		// �����д��һ��
		String msg = in.readUTF();
		int age = in.readInt();
		boolean flag = in.readBoolean();
		char ch = in.readChar();
		System.out.println(flag);

	}
}
