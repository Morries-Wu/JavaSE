package Polymorphic;

public class TestStaticInnerClass {
	public static void main(String[] args) {

		// 创建静态内部类不依托与外部类对象创建，可直接创建
		Outer2.Inner2 inner = new Outer2.Inner2();

	}
}

class Outer2 {

	static class Inner2 {

	}
}