package IOCommons;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;

//列出子孙及Morries
public class CommonsIO_Test03 {
	public static void main(String[] args) throws IOException {
		// 读取文件
		String msg = FileUtils.readFileToString(new File("empty.txt"), "GBK");
		System.out.println(msg);
		byte datas[] = FileUtils.readFileToByteArray(new File("empty.txt"));
		System.out.println(datas.length);
		System.out.println("--------------");

		// 逐行读取
		List<String> msgs = FileUtils.readLines(new File("empty.txt"), "GBK");
		for (String str : msgs) {
			System.out.println(str);
		}

		System.out.println("--------------");
		LineIterator it = FileUtils.lineIterator(new File("empty.txt"));
		while (it.hasNext()) {
			System.out.println(it.nextLine());
		}
	}
}
