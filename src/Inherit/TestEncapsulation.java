package Inherit;

public class TestEncapsulation {
//��װ
	public static void main(String[] args) {
		Human human = new Human();
	}
}

class Human {
	private int age;
	void sayAge() {
		System.out.println(age);
	}
}

class Boy {
	void sayHello() {
		System.out.println();
	}

}