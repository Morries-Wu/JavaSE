package Server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebContext {
	// ��ȡ����
	private List<Entity> entities;
	private List<Mapping> mappings;
	// Key: servlet-name value: servlet-class
	private Map<String, String> entityMap = new HashMap<String, String>();
	private Map<String, String> mappingMap = new HashMap<String, String>();

	// Key: url-pattern value: servlet-name
	public WebContext(List<Entity> entities, List<Mapping> mappings) {
		this.entities = entities;
		this.mappings = mappings;
		// ��entity��Listת���˶�Ӧmap
		for (Entity entity : entities) {
			entityMap.put(entity.getName(), entity.getClz());
		}
		// ��mapping��Listת���˶�Ӧmap
		for (Mapping mapping : mappings) {
			for (String pattern : mapping.getPatterns()) {
				mappingMap.put(pattern, mapping.getName()); 
			}
		}

	}

	//ͨ��URL��·���ҵ��˶�Ӧ��class
	public String getClz(String pattern) {
		String name = mappingMap.get(pattern);
		return entityMap.get(name);
	}

}
