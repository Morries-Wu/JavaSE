package Test;

import java.io.FileReader;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

//测试脚本执行JavaScript代码
public class Rhino {
	public static void main(String[] args) throws Exception {
		// 获得脚本引擎对象
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");

		// 定义变量,存储到引擎上下文中
		engine.put("msg", "mO is a good man!");
		String str = "var user={name:'mO',age:18,schools:['清华大学','深圳大学']};";
		str += "print(user.name)";

		// 执行脚本
		engine.eval(str);
		engine.eval("msg='Mo is a good boy';");
		System.out.println(engine.get("msg"));
		System.out.println("##################");

		// 定义函数
		engine.eval("function add(a,b){var sum=a+b;return sum;}");
		// 取得调用接口
		Invocable jsInvocable = (Invocable) engine;
		// 执行脚本定义的方法
		Object result = jsInvocable.invokeFunction("add", new Object[] { 13, 12 });
		System.out.println(result);

		// 导入其他的java包,使用其他包中的java类.若需要更深入了解细节,可以详细学习Rhino的语法
		String jsCode = "importPackage(java.util); var list=Arrays.asList([\"老狗哥\",\"清华\"]);";
		engine.eval(jsCode);

		List<String> list = (List<String>) engine.get("list");
		for (String temp : list) {
			System.out.println(temp);
		}

		// 执行一个js文件(我们将a.js置于项目的src下即可)
		URL url = Rhino.class.getClassLoader().getResource("a.js");
		engine.eval(new FileReader(url.getPath()));

	}
}
