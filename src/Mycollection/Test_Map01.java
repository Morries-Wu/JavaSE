package Mycollection;

import java.util.*;;

//测试Map的使用
public class Test_Map01 {
	public static void main(String[] args) {

		// 键不重复，若重复则重写键值
		Map<Integer, String> m = new HashMap<>();
		m.put(1, "one");// 1也是个对象，“one是字符串对象”
		m.put(2, "two");
		m.put(3, "three");
		System.out.println(m.get(1));

		System.out.println(m.size());
		System.out.println(m.isEmpty());
		System.out.println(m.containsKey(2));
		System.out.println(m.containsValue("6"));
		System.out.println();
		System.out.println();
		Map<Integer, String> m2 = new HashMap<>();
		m.put(4, "one");// 1也是个对象，“one是字符串对象”
		m.put(5, "two");
		m.putAll(m2);
		System.out.println(m);
		// map中键不能重复(是否重复是根据equals方法来判断)，则新的覆盖旧的
		m.put(3, "傻逼");
		System.out.println(m);
	}
}
