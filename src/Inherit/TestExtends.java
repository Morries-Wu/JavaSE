package Inherit;

public class TestExtends {

	public static void main(String[] args) {
		Student stu = new Student();
		stu.name = "���";
		stu.height = 175;
		stu.rest();
		Student stu2 = new Student("ϣϣ", 6, "�ھ��");
		System.out.println(stu2 instanceof Student);// ��ߵĶ����Ƿ����ұ���Ķ������Ƿ���true�����򷵻�false
		System.out.println(stu2 instanceof Person); // ��ߵĶ����Ƿ����ұ�������࣬���Ƿ���true,���򷵻�false

	}
}

class Person {
	String name;
	int height;

	public void rest() {
		System.out.println("��Ϣһ�ᣡ");
	}
}

class Student extends Person {

	String major;
	public Student() {
	}

	public void study() {
		System.out.println("ѧϰ��Сʱ��");
	}

	public Student(String name, int height, String major) {
		this.name = name;
		this.height = height;
		this.major = major;
	}

}
