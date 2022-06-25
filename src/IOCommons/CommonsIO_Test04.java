package IOCommons;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

//写出内容
public class CommonsIO_Test04 {
	public static void main(String[] args) throws IOException {
		// 写出文件
		FileUtils.write(new File("happy.txt"), "学习义不容辞\r\n", "GBK");
		FileUtils.writeStringToFile(new File("happy.txt"), "Morries学习义不容辞\r\n", "GBK", true);
		FileUtils.writeByteArrayToFile(new File("happy.txt"), "学习是一件幸福的事业\r\n".getBytes("GBK"), true);

		// 写出列表
		List<String> datas = new ArrayList<>();
		datas.add("马云");
		datas.add("马化腾");
		datas.add("弼马温");
		FileUtils.writeLines(new File("happy.txt"), datas, "\r\n", true);
	}
}
