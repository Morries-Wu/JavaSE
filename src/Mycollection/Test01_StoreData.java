package Mycollection;
//��ӱ�����ݵĴ洢

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
//�������Է��κΖ|��
//ORM˼��ļ�ʵ��:map��ʾһ������,���������Ƕ��map,�����map�ŵ�list��
public class Test01_StoreData {

	//HashMap�洢������洢��,��������޹���
	public static void main(String[] args) {
		Map<String, Object> row1 = new HashMap<>();
		row1.put("name", "����");
		row1.put("id", "1001");
		row1.put("нˮ", "20000");
		row1.put("��ְ����", "2018.5.5");

		Map<String, Object> row2 = new HashMap<>();
		row2.put("id", "1002");
		row2.put("name", "����");
		row2.put("��ְ����", "2005.4.4");
		row2.put("нˮ", 30000);
	

		Map<String, Object> row3 = new HashMap<>();
		row3.put("��ְ����", "2020.5.4");
		row3.put("id", "1003");
		row3.put("name", "����");
		row3.put("нˮ", "30000");


		List<Map<String, Object>> table = new ArrayList<>();
		table.add(row1);
		table.add(row2);
		table.add(row3);

		for (Map<String, Object> row : table) {
			Set<String> keySet = row.keySet();
			for (String key : keySet) {
				System.out.print(key + ":" + row.get(key) + "\t");
			}
			System.out.println();
		}
	}
}
