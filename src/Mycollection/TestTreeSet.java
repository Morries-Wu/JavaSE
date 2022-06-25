package Mycollection;

import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		set.add(3);
		set.add(200);
		set.add(600);

		// ����Ԫ�ص����ķ�ʽ�ź���
		for (Integer m : set) {
			System.out.println(m);
		}
		Set<Emp2> set2 = new TreeSet<>();
		set2.add(new Emp2(100, "����", 3000));
		set2.add(new Emp2(50, "����", 2000));
		set2.add(new Emp2(150, "����", 8000));
		set2.add(new Emp2(30, "����", 20000));

		for (Emp2 m : set2) {
			System.out.println(m);
		}
	}
}

class Emp2 implements Comparable<Emp2> {
	int id;
	double salary;
	String name;

	public Emp2(int id, String name, double salary) {
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
	public int compareTo(Emp2 o) {
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
