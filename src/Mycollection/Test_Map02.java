package Mycollection;

import java.util.*;;

//测试Map的使用
public class Test_Map02 {
	public static void main(String[] args) {
		Employee e1 = new Employee(1001, "祥哥", 5000);
		Employee e2 = new Employee(1002, "狗哥", 6000);
		Employee e3 = new Employee(1003, "标哥", 7000);

		Map<Integer, Employee> map = new HashMap<>();
		map.put(1001, e1);					
		map.put(1002, e2);
		map.put(1003, e3);
		System.out.println(map.get(1002));
		Employee emp = map.get(1001);
		System.out.println(emp);
	}
}

class Employee {
	private int id;
	private String name;
	private double salary;

	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
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

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String toString() {
		return "id:" + id + "\tname:" + name + "\t薪水:" + salary;
	}

}