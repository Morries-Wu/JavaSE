package Mycollection;

import java.util.*;

//����Collection�ӿ��еķ���
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
//		list.addAll(list2);       //��list2ȫ����ӵ�list����
//		list.removeAll(list2);   //����ͬ��ɾ��
		list.retainAll(list2); // ȡ����
		System.out.println(list.containsAll(list2)); // list�Ƿ����list2��������Ԫ��
		System.out.println("list:" + list);
	}
}
