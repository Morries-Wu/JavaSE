package Mycollection;

import java.util.*;

//测试Collection接口中的方法
public class TestList {
	public static void main(String[] args) {
		test02();
	}

	public static void test01() {
	}

	public static void test02() {
		List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("bb");
		list.add("cc");

		List<String> list2 = new ArrayList<>();
		list2.add("aa");
		list2.add("dd");
		list2.add("ee");
		System.out.println("list:" + list);
//		list.addAll(list2);       //把list2全部添加到list里面
//		list.removeAll(list2);   //把相同的删除
		list.retainAll(list2); // 取交集
		System.out.println(list.containsAll(list2)); // list是否包含list2里面所有元素
		System.out.println("list:" + list);
	}
}
