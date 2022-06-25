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

//��ϤSAX��������
public class XML_Test03 {
	public static void main(String[] args) throws Exception {
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
		WebContext context = new WebContext(handler.getEntities(), handler.getMappings());

		List<Entity> entities = handler.getEntities();
		List<Mapping> mappings = handler.getMappings();
		for (Entity entity : entities) {
			System.out.println(entity.getName() + "  " + entity.getClz());
		}
		// ��mapping��Listת���˶�Ӧmap
		for (Mapping mapping : mappings) {
			for (String pattern : mapping.getPatterns()) {
				System.out.println(pattern + "  " + mapping.getName());
			}
		}

		System.out.println();
		// ������������/login
		String classname = context.getClz("/login");
		System.out.println(classname);
		Class clz = Class.forName(classname);
		Servlet servlet = (Servlet) clz.getConstructor().newInstance();
		System.out.println(servlet);
		// servlet.service();
	}
}
