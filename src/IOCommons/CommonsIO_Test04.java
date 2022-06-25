package IOCommons;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

//д������
public class CommonsIO_Test04 {
	public static void main(String[] args) throws IOException {
		// д���ļ�
		FileUtils.write(new File("happy.txt"), "ѧϰ�岻�ݴ�\r\n", "GBK");
		FileUtils.writeStringToFile(new File("happy.txt"), "Morriesѧϰ�岻�ݴ�\r\n", "GBK", true);
		FileUtils.writeByteArrayToFile(new File("happy.txt"), "ѧϰ��һ���Ҹ�����ҵ\r\n".getBytes("GBK"), true);

		// д���б�
		List<String> datas = new ArrayList<>();
		datas.add("����");
		datas.add("����");
		datas.add("������");
		FileUtils.writeLines(new File("happy.txt"), datas, "\r\n", true);
	}
}
