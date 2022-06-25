package Test;

import java.io.FileReader;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

//���Խű�ִ��JavaScript����
public class Rhino {
	public static void main(String[] args) throws Exception {
		// ��ýű��������
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");

		// �������,�洢��������������
		engine.put("msg", "mO is a good man!");
		String str = "var user={name:'mO',age:18,schools:['�廪��ѧ','���ڴ�ѧ']};";
		str += "print(user.name)";

		// ִ�нű�
		engine.eval(str);
		engine.eval("msg='Mo is a good boy';");
		System.out.println(engine.get("msg"));
		System.out.println("##################");

		// ���庯��
		engine.eval("function add(a,b){var sum=a+b;return sum;}");
		// ȡ�õ��ýӿ�
		Invocable jsInvocable = (Invocable) engine;
		// ִ�нű�����ķ���
		Object result = jsInvocable.invokeFunction("add", new Object[] { 13, 12 });
		System.out.println(result);

		// ����������java��,ʹ���������е�java��.����Ҫ�������˽�ϸ��,������ϸѧϰRhino���﷨
		String jsCode = "importPackage(java.util); var list=Arrays.asList([\"�Ϲ���\",\"�廪\"]);";
		engine.eval(jsCode);

		List<String> list = (List<String>) engine.get("list");
		for (String temp : list) {
			System.out.println(temp);
		}

		// ִ��һ��js�ļ�(���ǽ�a.js������Ŀ��src�¼���)
		URL url = Rhino.class.getClassLoader().getResource("a.js");
		engine.eval(new FileReader(url.getPath()));

	}
}
