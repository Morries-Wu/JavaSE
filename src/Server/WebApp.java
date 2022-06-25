package Server;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class WebApp {
	private static WebContext context;
	static {
		try {
			// SAX解析
			// 1、获取解析工厂
			SAXParserFactory factory = SAXParserFactory.newInstance();
			// 2、从解析工厂获取解析器
			SAXParser parse = factory.newSAXParser();
			// 3、编写处理器
			WebHandler handler = new WebHandler();
			// 4、加载文档Document注册器
			// 5、解析
			parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("Web02.xml"), handler);
			// 获取数据
			context = new WebContext(handler.getEntities(), handler.getMappings());
		} catch (Exception e) {
			System.out.println("解析配置文件错误");
		}
	}

	// 通过url获取配置文件对应的Servlet
	public static Servlet getServletFromUrl(String url) {
		// 假设你输入了/login
		String classname = context.getClz("/" + url);
		Class clz;
		try {
			clz = Class.forName(classname);
			Servlet servlet = (Servlet) clz.getConstructor().newInstance();
			return servlet;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
