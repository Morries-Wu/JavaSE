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
public class XML_Test02 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// SAX解析
		// 1、获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2、从解析工厂获取解析器
		SAXParser parse = factory.newSAXParser();
		// 3、编写处理器
		PersonHandler handler = new PersonHandler();
		// 4、加载文档Document注册器
		// 5、解析
		parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("Web02.xml"), handler);

		// 获取数据
		List<Person> persons = handler.getPersons();
		for (Person person : persons) {
			System.out.println(person.getName() + "  " + person.getAge());
		}
	}
}

class PersonHandler extends DefaultHandler {
	private List<Person> persons;
	private Person temp;
	private String tag;// 存储操作标签

	public List<Person> getPersons() {
		return persons;
	}

	public void startDocument() throws SAXException {
		persons = new ArrayList<Person>();
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName + "-->解析开始");// qName表示标签或者元素名
		tag = qName;// 存储标签名
		if (tag != null) {
			if (tag.equals("person")) {
				temp = new Person();
			}
		}

	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch, start, length).trim();
		if (tag != null) {// 处理了空
			if (tag.equals("name")) {
				temp.setName(contents);
			} else if (tag.equals("age")) {
				temp.setAge(Integer.valueOf(contents));
			}
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.print(qName + "-->解析结束 ");// qName表示标签或者元素名
		if (qName != null) {// 处理了空
			if (qName.equals("person")) {
				persons.add(temp);
			}
		}
		tag = null;// tag丢弃了
	}

	public void endDocument() throws SAXException {
		System.out.println("--解析文档结束--");
	}
	
	
	

}