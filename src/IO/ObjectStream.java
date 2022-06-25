	package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


//对象流
//1.写出后读取
//2.读取的顺序与写出保持一致
//3.不是所有的对象都可以序列化Serializable
public class ObjectStream {
	public static void main(String[] args) throws Exception {

		// 写出
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(baos));
		// 操作数据类型+数据
		out.writeUTF("编码太难了");
		out.writeInt(18);
		out.writeBoolean(false);
		Employee emp = new Employee("吴嘉明", 66666);
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
	private  String name;// 该数据不需要序列化
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