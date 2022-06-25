package IOCommons;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

//写出内容
public class CommonsIO_Test05 {
	public static void main(String[] args) throws IOException {
		// 复制文件
		// FileUtils.copyFile(new File("copy.jpg"), new File("jpg-copy.jpg"));
		// 复制文件到目录
		// FileUtils.copyToDirectory(new File("copy.jpg"), new File("lib"));
		// 复制目录到目录
		// FileUtils.copyDirectoryToDirectory(new File("lib"), new File("lib2"));
		// 复制URL内容
		String url = "https://i0.hdslb.com/bfs/face/ba310c8c770325dfd0caead95ac2a6323226aefb.jpg@128w_128h_1o.webp";
		FileUtils.copyURLToFile(new URL(url), new File("new.jpg"));

		String datas = IOUtils.toString(new URL("http://www.baidu.com"), "UTF-8");
		System.out.println(datas);
	}
}
