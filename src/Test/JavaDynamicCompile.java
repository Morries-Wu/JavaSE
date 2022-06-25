package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.instrument.ClassFileTransformer;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import com.mchange.v2.c3p0.impl.NewPooledConnection;

//动态编译的应用场景:可以做一个浏览器端编写java代码,上传服务器编译和运行的在线评测系统
public class JavaDynamicCompile {
	public static void main(String[] args) throws IOException {

		// 通过Io流操作,将字符串存储成一个临时文件(Hi,Java),然后调用动态编译方法
		String str = "public class Hi{ public static void main(String [] args){System.out.println(\"HAHA,祥哥\");}}";

		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null,
				"F:/Multifunctionapplication/Advanced Files/Java Project/myjava/HelloWorld.java");
		System.out.println(result == 0 ? "编译成功" : "编译失败");

		// 通过Runtime调用执行类
		Runtime run = Runtime.getRuntime();
		Process process = run
				.exec("java	-cp	 F:/Multifunctionapplication/Advanced Files/Java Project/myjava     HelloWorld");

		InputStream in = process.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String info = "";
		while ((info = reader.readLine()) != null) {
			System.out.println(info);
		}

		try {
			URL urls[] = new URL[] { new URL(
					"file:/" + "F:/Multifunctionapplication/Advanced Files/Java Project/myjava/") };
			URLClassLoader loader = new URLClassLoader(urls);
			Class clazz = loader.loadClass("HelloWorld");
			// 调用加载类的main方法
			Method method = clazz.getMethod("main", String[].class);
			method.invoke(null, (Object) new String[] {});
			// 由于可变参数是JDK5.0之后才有method.invoke(null, (Object) new String[] {"aa","bb"});
			// public static void mmm(String []a,String []b);就发生了参数个数不匹配的问题,因此必须要加上(Object)转型,避免这个问题
			// public static void main("aa","bb");
			// public static void main(new String[]{"aa","bb"});
			// public static void main(String []args);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
