package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//ת����:InputStreamReader OutputStreamWriter
//1�����ַ�������ʽ�����ֽ���(���ı�)
//2��ָ���ַ���
public class Convert_Test01 {
	public static void main(String[] args) {
		// ����System.in��System.out

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));) {
			// ѭ����ȡ��������(exit�˳�),���������
			String msg = "";
			while (!msg.equals("exit")) {
				// ѭ����ȡ
				msg = reader.readLine();// ѭ����ȡ
				writer.write(msg);// ѭ��д��
				writer.flush();
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("�����쳣");
		}

	}
}
