package Server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebContext {
	// 获取数据
	private List<Entity> entities;
	private List<Mapping> mappings;
	// Key: servlet-name value: servlet-class
	private Map<String, String> entityMap = new HashMap<String, String>();
	private Map<String, String> mappingMap = new HashMap<String, String>();

	// Key: url-pattern value: servlet-name
	public WebContext(List<Entity> entities, List<Mapping> mappings) {
		this.entities = entities;
		this.mappings = mappings;
		// 将entity的List转成了对应map
		for (Entity entity : entities) {
			entityMap.put(entity.getName(), entity.getClz());
		}
		// 将mapping的List转成了对应map
		for (Mapping mapping : mappings) {
			for (String pattern : mapping.getPatterns()) {
				mappingMap.put(pattern, mapping.getName()); 
			}
		}

	}

	//通过URL的路径找到了对应的class
	public String getClz(String pattern) {
		String name = mappingMap.get(pattern);
		return entityMap.get(name);
	}

}
