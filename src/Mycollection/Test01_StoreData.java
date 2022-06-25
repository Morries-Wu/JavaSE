package Mycollection;
//添加表格数据的存储

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
//容器可以放任何東西
//ORM思想的简单实验:map表示一行数据,多行数据是多个map,将多个map放到list中
public class Test01_StoreData {

	//HashMap存储是无序存储的,但输出是无规格的
	public static void main(String[] args) {
		Map<String, Object> row1 = new HashMap<>();
		row1.put("name", "张三");
		row1.put("id", "1001");
		row1.put("薪水", "20000");
		row1.put("入职日期", "2018.5.5");

		Map<String, Object> row2 = new HashMap<>();
		row2.put("id", "1002");
		row2.put("name", "李四");
		row2.put("入职日期", "2005.4.4");
		row2.put("薪水", 30000);
	

		Map<String, Object> row3 = new HashMap<>();
		row3.put("入职日期", "2020.5.4");
		row3.put("id", "1003");
		row3.put("name", "王五");
		row3.put("薪水", "30000");


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
