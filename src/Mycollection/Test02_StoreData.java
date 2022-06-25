package Mycollection;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//���Ա�����ݵĴ洢
//���ORM˼��
//ÿһ������ʹ��javabean����洢,����ʹ�÷ŵ�map��list��
public class Test02_StoreData {
	public static void main(String[] args) {
		User user1 = new User(1001, "����", 20000, "2018.5.5");
		User user2 = new User(1002, "����", 30000, "2005.4.4");
		User user3 = new User(1003, "����", 30000, "2020.5.4");

		List<User> list = new ArrayList<>();
		list.add(user1); 
		list.add(user2); 
		list.add(user3); 

		for (User u : list) {
			System.out.println(u);
		}

		Map<Integer, User> map = new HashMap<>();
		map.put(1001, user1);
		map.put(1002, user2);
		map.put(1003, user3);
		Set<Integer> keySet = map.keySet();
		for (Integer key : keySet) {
			System.out.println("Key:" + key +"    value  "+ map.get(key));
		}
	}
}

class User {
	// javabean���Ƕ���һ����,��������
	// һ��������JavaBean,Ҫ��Set��Get�������Լ��޲ι�����
	private int id;
	private String name;
	private double salary;
	private String hiredate;

	public User() {
	}

	public User(int id, String name, double salary, String hiredate) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.hiredate = hiredate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:" + id + " name:" + name + " salary:" + salary + " hiredate:" + hiredate;
	}
}