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

		// ����HashTab
		HashTable hashTable = new HashTable(7);

		// дһ���򵥵ĳ���
		String in = " ";
		boolean flag = true;
		while (flag) {
			System.out.println("add:��ӹ�Ա");
			System.out.println("list:��ʾ��Ա");
			System.out.println("exit:�˳�����");
			in = in_string();
			switch (in) {
			case "add":
				System.out.println("����id");
				int id = in_int();
				System.out.println("��������");
				String name = in_string();
				// ������Ա
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

//����HashTab ������ű�
class HashTable {
	private EmplinKedList[] emplinKedListArray;
	private int size;// ��ʾ�ж���������

	public HashTable(EmplinKedList[] emplinKedListArray) {
		super();
		this.emplinKedListArray = emplinKedListArray;
	}

	// ������
	public HashTable(int size) {
		// ��ʼ��emplinKedListArray
		this.size = size;
		emplinKedListArray = new EmplinKedList[size];
		for (int i = 0; i < size; i++) {
			emplinKedListArray[i] = new EmplinKedList();
		}
	}

	// ��ӹ�Ա
	public void add(Emp emp) {
		// ����Ա����id,�õ���Ա��Ӧ����ӵ���������
		int emplinKedListNo = hashFun(emp.id);
		// ��emp��ӵ���Ӧ��������
		emplinKedListArray[emplinKedListNo].add(emp);
	}

	public void list() {
		for (int i = 0; i < size; i++) {
			emplinKedListArray[i].list(i);
		}
	}

	// ��дһ��ɢ�к���,ʹ��һ����ȡģ��
	public int hashFun(int id) {
		return id % size;
	}
}

//����EmplinKedList,��ʾ����
class EmplinKedList {

	// ͷָ��,ִ�е�һ��emp,���������������head,��ֱ��ָ���һ��emp
	private Emp head;// Ĭ��Ϊnull

	// ���Ա��������
	// ˵��
	// 1.�ٶ�,����ӹ�Աʱ,id��������,��id�ķ������Ǵ�С����
	// ������ǽ��ù�Աֱ�Ӽ��뵽���������󼴿�
	public void add(Emp emp) {
		// �������ӵ�һ��Ա��
		if (head == null) {
			head = emp;
			return;
		}

		// ������ǵ�һ����Ա��ʹ��һ��������ָ��,������λ�����
		Emp temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		// �˳�ʱֱ�ӽ�emp�ӵ����Ϳ���
		temp.next = emp;
	}

	// ��������Ĺ�Ա��Ϣ
	public void list(int num) {
		if (head == null) {
			// ˵������Ϊ��
			System.out.println("��" + num + 1 + "������Ϊ��");
			return;
		}
		System.out.println("��" + num + 1 + "���������ϢΪ");
		Emp temp = head; // ����ָ��
		while (temp != null) {
			System.out.printf("id=%d  name=%s\n", temp.id, temp.name);
			temp = temp.next;
		}
	}
}
	
//��ʾһ����Ա
class Emp {
	public int id;
	public String name;
	public Emp next;// nextĬ��Ϊ��

	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
