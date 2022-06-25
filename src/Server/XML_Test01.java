package Server;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//��ϤSAX��������
public class XML_Test01 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// SAX����
		// 1����ȡ��������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2���ӽ���������ȡ������
		SAXParser parse = factory.newSAXParser();
		// 3����д������
		// 4�������ĵ�Documentע����
		PHandler handler = new PHandler(); 
		// 5������
		parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("Web01.xml"), handler);
	}
}

class PHandler extends DefaultHandler {

	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch, start, length).trim();
		if (contents.length() > 0) {
			System.out.println("����Ϊ-->" + contents);
		}else {
			System.out.println("����Ϊ-->" +"��");
		}

	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("--�����ĵ���ʼ--");
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName + "-->������ʼ");// qName��ʾ��ǩ����Ԫ����
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.print(qName + "-->��������");// qName��ʾ��ǩ����Ԫ����
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("--�����ĵ�����--");
	}

}