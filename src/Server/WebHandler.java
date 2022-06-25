package Server;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
//处理器
public class WebHandler extends DefaultHandler {
	private List<Entity> entities;
	private List<Mapping> mappings;
	private Entity entity;
	private Mapping mapping;
	private boolean isMapping = false;
	private String tag;// 存储操作标签

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
		tag = qName;// 存储标签名
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
		if (tag != null) {// 处理了空
			if (isMapping == true) {// 操作servlet-mapping
				if (tag.equals("servlet-name")) {
					mapping.setName(contents);
				} else if (tag.equals("url-pattern")) {
					mapping.addPattern(contents);
				}

			} else {// 操作servlet
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
		tag = null;// tag丢弃了
	}

}