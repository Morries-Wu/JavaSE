package IOCommons;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;

//列出子孙及Morries
public class CommonsIO_Test02 {
	public static void main(String[] args) {
		Collection<File> files = FileUtils.listFiles(
				new File("F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice"),
				EmptyFileFilter.NOT_EMPTY, null);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}

		//过滤其他类型数据,留存文件后缀为jpg类型数据
		System.out.println("-----------------------------------------------------------------------\n\n\n\n\n\n");
		files = FileUtils.listFiles(new File("F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice"),
				new SuffixFileFilter("jpg"), DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}

		//过滤其他类型数据,留存文件后缀为java类型数据或者后缀为class类型
		System.out.println("-----------------------------------------------------------------------\n\n\n\n\n\n");
		files = FileUtils.listFiles(new File("F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice"),
				FileFilterUtils.or(new SuffixFileFilter("java"), new SuffixFileFilter("class")),
				DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}

		//过滤其他类型数据,留存文件后缀为java类型数据和后缀为class类型
		System.out.println("-----------------------------------------------------------------------\n\n\n\n\n\n");
		files = FileUtils.listFiles(
				new File("F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice\\jAVA300\\IOCommons"),
				FileFilterUtils.and(new SuffixFileFilter("java"), EmptyFileFilter.NOT_EMPTY),
				DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}

	}
}
