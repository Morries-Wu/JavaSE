package Java.Math.HashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class HashtableDemo {

	public static String in_string() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			String to = in.readLine();
			return to;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int in_int() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			int to = Integer.parseInt(in.readLine());
			return to;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {

		// 创建HashTab
		HashTable hashTable = new HashTable(7);

		// 写一个简单的程序
		String in = " ";
		boolean flag = true;
		while (flag) {
			System.out.println("add:添加雇员");
			System.out.println("list:显示雇员");
			System.out.println("exit:退出程序");
			in = in_string();
			switch (in) {
			case "add":
				System.out.println("输入id");
				int id = in_int();
				System.out.println("输入名字");
				String name = in_string();
				// 创建雇员
				Emp emp = new Emp(id, name);
				hashTable.add(emp);
				break;
			case "list":
				hashTable.list();
				break;
			case "exit":
				flag = false;
				break;
			default:
				break;
			}
		}
	}
}

//创建HashTab 管理多张表
class HashTable {
	private EmplinKedList[] emplinKedListArray;
	private int size;// 表示有多少条链表

	public HashTable(EmplinKedList[] emplinKedListArray) {
		super();
		this.emplinKedListArray = emplinKedListArray;
	}

	// 构造器
	public HashTable(int size) {
		// 初始化emplinKedListArray
		this.size = size;
		emplinKedListArray = new EmplinKedList[size];
		for (int i = 0; i < size; i++) {
			emplinKedListArray[i] = new EmplinKedList();
		}
	}

	// 添加雇员
	public void add(Emp emp) {
		// 根据员工的id,得到该员工应当添加到哪条链表
		int emplinKedListNo = hashFun(emp.id);
		// 将emp添加到对应的链表中
		emplinKedListArray[emplinKedListNo].add(emp);
	}

	public void list() {
		for (int i = 0; i < size; i++) {
			emplinKedListArray[i].list(i);
		}
	}

	// 编写一个散列函数,使用一个简单取模法
	public int hashFun(int id) {
		return id % size;
	}
}

//创建EmplinKedList,表示链表
class EmplinKedList {

	// 头指针,执行第一个emp,因此我们这个链表的head,是直接指向第一个emp
	private Emp head;// 默认为null

	// 添加员工到链表
	// 说明
	// 1.假定,当添加雇员时,id是自增长,即id的分配总是从小到大
	// 因此我们将该雇员直接加入到本链表的最后即可
	public void add(Emp emp) {
		// 如果是添加第一个员工
		if (head == null) {
			head = emp;
			return;
		}

		// 如果不是第一个雇员则使用一个辅助的指针,帮助定位到最后
		Emp temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		// 退出时直接将emp加到最后就可以
		temp.next = emp;
	}

	// 遍历链表的雇员信息
	public void list(int num) {
		if (head == null) {
			// 说明链表为空
			System.out.println("第" + num + 1 + "号链表为空");
			return;
		}
		System.out.println("第" + num + 1 + "号链表的信息为");
		Emp temp = head; // 辅助指针
		while (temp != null) {
			System.out.printf("id=%d  name=%s\n", temp.id, temp.name);
			temp = temp.next;
		}
	}
}
	
//表示一个雇员
class Emp {
	public int id;
	public String name;
	public Emp next;// next默认为空

	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
