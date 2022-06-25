package Server;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class WebApp {
	private static WebContext context;
	static {
		try {
			// SAX����
			// 1����ȡ��������
			SAXParserFactory factory = SAXParserFactory.newInstance();
			// 2���ӽ���������ȡ������
			SAXParser parse = factory.newSAXParser();
			// 3����д������
			WebHandler handler = new WebHandler();
			// 4�������ĵ�Documentע����
			// 5������
			parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("Web02.xml"), handler);
			// ��ȡ����
			context = new WebContext(handler.getEntities(), handler.getMappings());
		} catch (Exception e) {
			System.out.println("���������ļ�����");
		}
	}

	// ͨ��url��ȡ�����ļ���Ӧ��Servlet
	public static Servlet getServletFromUrl(String url) {
		// ������������/login
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
