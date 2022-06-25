package Inherit;

public class TestExtends {

	public static void main(String[] args) {
		Student stu = new Student();
		stu.name = "祥哥";
		stu.height = 175;
		stu.rest();
		Student stu2 = new Student("希希", 6, "挖掘机");
		System.out.println(stu2 instanceof Student);// 左边的对象是否是右边类的对象，若是返回true，否则返回false
		System.out.println(stu2 instanceof Person); // 左边的对象是否是右边类的子类，若是返回true,否则返回false

	}
}

class Person {
	String name;
	int height;

	public void rest() {
		System.out.println("休息一会！");
	}
}

class Student extends Person {

	String major;
	public Student() {
	}

	public void study() {
		System.out.println("学习两小时！");
	}

	public Student(String name, int height, String major) {
		this.name = name;
		this.height = height;
		this.major = major;
	}

}
