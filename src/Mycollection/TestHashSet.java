package Mycollection;

import java.util.HashSet;
import java.util.Set;
//Set:û��˳��,�����ظ�
//List:��˳��,���ظ�
//HashSet���Ǽ򻯰�HashMap

public class TestHashSet {
	public static void main(String[] args) {
		// Set�����ص㣺���򡢲����ظ�����Ԫ�������Set��ĳ��Ԫ��ͨ��equals()�����Ա�Ϊtrue�����ܼ���
		// Set���õ�ʵ�����У�HashSet��TreeSet��.����һ��ʹ��HashSet
		Set<String> set = new HashSet<String>();
		set.add("aa");
		set.add("bb");
		set.add("aa");
		System.out.println(set);
		set.remove("bb");
		System.out.println(set);
		Set<String> set2 = new HashSet<>();
		set2.add("���");
		set2.addAll(set);
		System.out.println(set2);
	}
}
