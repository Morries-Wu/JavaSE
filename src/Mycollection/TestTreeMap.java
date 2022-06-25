package Mycollection;

import java.util.Map;
import java.util.TreeMap;

//HashMap线程不安全,效率高，允许Key或value为null;
//HashTable:线程安全，效率低,不允许key或value为null;
public class TestTreeMap {
	public static void main(String[] args) {
		Map<Integer, String> treemap = new TreeMap<>();
		treemap.put(20, "aa");
		treemap.put(3, "bb");
		treemap.put(6, "cc");

		// 按照key递赠的方式排序
		for (Integer key : treemap.keySet()) {
			System.out.println(key + "---" + treemap.get(key));
		}

		Map<Emp, String> treeMap2 = new TreeMap<Emp, String>();
		treeMap2.put(new Emp(100, "张三", 50000), "张三是个好家伙");
		treeMap2.put(new Emp(200, "李四", 5000), "李四工作不积极");
		treeMap2.put(new Emp(30, "王五", 6000), "王五工作还不错");
		treeMap2.put(new Emp(50, "老六", 6000), "老六是个开心果");

		for (Emp key : treeMap2.keySet()) {
			System.out.println(key + "---" + treeMap2.get(key));
		}
	}
}

class Emp implements Comparable<Emp> {
	int id;
	double salary;
	String name;

	public Emp(int id, String name, double salary) {
		super();
		this.id = id;
		this.salary = salary;
		this.name = name;
	}

	@Override
	public String toString() {
		return "id:" + id + ",name:" + name + ",salary:" + salary;
	}

	@Override
	public int compareTo(Emp o) {
		// 负数：小于 0：等于 正数：大于
		if (this.salary > o.salary) {
			return 1;
		} else if (this.salary < o.salary) {
			return -1;
		} else {
			if (this.id > o.id) {
				return 1;
			} else if (this.id < o.id) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}
