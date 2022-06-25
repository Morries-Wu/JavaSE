	package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


//������
//1.д�����ȡ
//2.��ȡ��˳����д������һ��
//3.�������еĶ��󶼿������л�Serializable
public class ObjectStream {
	public static void main(String[] args) throws Exception {

		// д��
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(baos));
		// ������������+����
		out.writeUTF("����̫����");
		out.writeInt(18);
		out.writeBoolean(false);
		Employee emp = new Employee("�����", 66666);
		out.writeObject(emp);
		out.flush();
		byte datas[] = baos.toByteArray();
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		String msg = in.readUTF();
		int age = in.readInt();
		boolean flag = in.readBoolean();
		Object employee = in.readObject();

		if (msg instanceof String) {
			String str = (String) msg;
			System.out.println(str);
		}

		if (employee instanceof Employee) {
			Employee empobj = (Employee) employee;
			System.out.println(empobj.getName() + empobj.getSalary());
		}
		out.close();
	}
}

//javabeen
class Employee implements Serializable {
	private  String name;// �����ݲ���Ҫ���л�
	private double salary;

	public Employee() {

	}

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
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
}