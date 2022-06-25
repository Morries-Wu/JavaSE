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
public class XML_Test02 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// SAX����
		// 1����ȡ��������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2���ӽ���������ȡ������
		SAXParser parse = factory.newSAXParser();
		// 3����д������
		PersonHandler handler = new PersonHandler();
		// 4�������ĵ�Documentע����
		// 5������
		parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("Web02.xml"), handler);

		// ��ȡ����
		List<Person> persons = handler.getPersons();
		for (Person person : persons) {
			System.out.println(person.getName() + "  " + person.getAge());
		}
	}
}

class PersonHandler extends DefaultHandler {
	private List<Person> persons;
	private Person temp;
	private String tag;// �洢������ǩ

	public List<Person> getPersons() {
		return persons;
	}

	public void startDocument() throws SAXException {
		persons = new ArrayList<Person>();
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName + "-->������ʼ");// qName��ʾ��ǩ����Ԫ����
		tag = qName;// �洢��ǩ��
		if (tag != null) {
			if (tag.equals("person")) {
				temp = new Person();
			}
		}

	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch, start, length).trim();
		if (tag != null) {// �����˿�
			if (tag.equals("name")) {
				temp.setName(contents);
			} else if (tag.equals("age")) {
				temp.setAge(Integer.valueOf(contents));
			}
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.print(qName + "-->�������� ");// qName��ʾ��ǩ����Ԫ����
		if (qName != null) {// �����˿�
			if (qName.equals("person")) {
				persons.add(temp);
			}
		}
		tag = null;// tag������
	}

	public void endDocument() throws SAXException {
		System.out.println("--�����ĵ�����--");
	}
	
	
	

}