package Mycollection;

import java.util.HashSet;
import java.util.Set;
//Set:没有顺序,不可重复
//List:有顺序,可重复
//HashSet就是简化版HashMap

public class TestHashSet {
	public static void main(String[] args) {
		// Set容器特点：无序、不可重复。新元素如果和Set中某个元素通过equals()方法对比为true，则不能加入
		// Set常用的实现类有：HashSet、TreeSet等.我们一般使用HashSet
		Set<String> set = new HashSet<String>();
		set.add("aa");
		set.add("bb");
		set.add("aa");
		System.out.println(set);
		set.remove("bb");
		System.out.println(set);
		Set<String> set2 = new HashSet<>();
		set2.add("祥哥");
		set2.addAll(set);
		System.out.println(set2);
	}
}
