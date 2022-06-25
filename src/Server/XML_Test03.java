package Server;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//熟悉SAX解析流程
public class XML_Test03 {
	public static void main(String[] args) throws Exception {
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
		WebContext context = new WebContext(handler.getEntities(), handler.getMappings());

		List<Entity> entities = handler.getEntities();
		List<Mapping> mappings = handler.getMappings();
		for (Entity entity : entities) {
			System.out.println(entity.getName() + "  " + entity.getClz());
		}
		// 将mapping的List转成了对应map
		for (Mapping mapping : mappings) {
			for (String pattern : mapping.getPatterns()) {
				System.out.println(pattern + "  " + mapping.getName());
			}
		}

		System.out.println();
		// 假设你输入了/login
		String classname = context.getClz("/login");
		System.out.println(classname);
		Class clz = Class.forName(classname);
		Servlet servlet = (Servlet) clz.getConstructor().newInstance();
		System.out.println(servlet);
		// servlet.service();
	}
}
