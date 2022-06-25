package Mycollection;

import java.util.Map;
import java.util.TreeMap;

//HashMap�̲߳���ȫ,Ч�ʸߣ�����Key��valueΪnull;
//HashTable:�̰߳�ȫ��Ч�ʵ�,������key��valueΪnull;
public class TestTreeMap {
	public static void main(String[] args) {
		Map<Integer, String> treemap = new TreeMap<>();
		treemap.put(20, "aa");
		treemap.put(3, "bb");
		treemap.put(6, "cc");

		// ����key�����ķ�ʽ����
		for (Integer key : treemap.keySet()) {
			System.out.println(key + "---" + treemap.get(key));
		}

		Map<Emp, String> treeMap2 = new TreeMap<Emp, String>();
		treeMap2.put(new Emp(100, "����", 50000), "�����Ǹ��üһ�");
		treeMap2.put(new Emp(200, "����", 5000), "���Ĺ���������");
		treeMap2.put(new Emp(30, "����", 6000), "���幤��������");
		treeMap2.put(new Emp(50, "����", 6000), "�����Ǹ����Ĺ�");

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
		// ������С�� 0������ ����������
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
