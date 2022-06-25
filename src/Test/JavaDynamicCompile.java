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

//��̬�����Ӧ�ó���:������һ��������˱�дjava����,�ϴ���������������е���������ϵͳ
public class JavaDynamicCompile {
	public static void main(String[] args) throws IOException {

		// ͨ��Io������,���ַ����洢��һ����ʱ�ļ�(Hi,Java),Ȼ����ö�̬���뷽��
		String str = "public class Hi{ public static void main(String [] args){System.out.println(\"HAHA,���\");}}";

		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null,
				"F:/Multifunctionapplication/Advanced Files/Java Project/myjava/HelloWorld.java");
		System.out.println(result == 0 ? "����ɹ�" : "����ʧ��");

		// ͨ��Runtime����ִ����
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
			// ���ü������main����
			Method method = clazz.getMethod("main", String[].class);
			method.invoke(null, (Object) new String[] {});
			// ���ڿɱ������JDK5.0֮�����method.invoke(null, (Object) new String[] {"aa","bb"});
			// public static void mmm(String []a,String []b);�ͷ����˲���������ƥ�������,��˱���Ҫ����(Object)ת��,�����������
			// public static void main("aa","bb");
			// public static void main(new String[]{"aa","bb"});
			// public static void main(String []args);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
