package Server;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
//������
public class WebHandler extends DefaultHandler {
	private List<Entity> entities;
	private List<Mapping> mappings;
	private Entity entity;
	private Mapping mapping;
	private boolean isMapping = false;
	private String tag;// �洢������ǩ

	public List<Entity> getEntities() {
		return entities;
	}

	public List<Mapping> getMappings() {
		return mappings;
	}

	public void startDocument() throws SAXException {
		entities = new ArrayList<Entity>();
		mappings = new ArrayList<Mapping>();
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		tag = qName;// �洢��ǩ��
		if (tag != null) {
			if (tag.equals("servlet")) {
				entity = new Entity();
				isMapping = false;
			} else if (tag.equals("servlet-mapping")) {
				mapping = new Mapping();
				isMapping = true;
			}
		}

	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch, start, length).trim();
		if (tag != null) {// �����˿�
			if (isMapping == true) {// ����servlet-mapping
				if (tag.equals("servlet-name")) {
					mapping.setName(contents);
				} else if (tag.equals("url-pattern")) {
					mapping.addPattern(contents);
				}

			} else {// ����servlet
				if (tag.equals("servlet-name")) {
					entity.setName(contents);
				} else if (tag.equals("servlet-class")) {
					entity.setClz(contents);
				}
			}
		}

	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName != null) {
			if (qName.equals("servlet")) {
				entities.add(entity);
			} else if (qName.equals("servlet-mapping")) {
				mappings.add(mapping);
			}
		}
		tag = null;// tag������
	}

}