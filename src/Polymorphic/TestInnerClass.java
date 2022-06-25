package Polymorphic;

//测试非静态内部类
public class TestInnerClass {
	public static void main(String[] args) {
		// 创建内部类对象
		Outer.Inner inner = new Outer().new Inner();
		inner.show();
	}
}

class Outer {// 是一个普通类

	// 非静态内部类可以直接访问外部类的成员，但外部类不能直接访问非静态内部类成员
	private int age = 10;

	public void testOuter() {
		System.out.println("Outer.testOuter()"); 
	}

	// 非静态内部类不能有静态方法，静态属性和静态初始化块
	// 静态内部类方法对应静态内部类
	class Inner {
		int age = 20;

		public void show() {
			int age = 30;
			System.out.println("外部类的成员变量age:" + Outer.this.age);
			System.out.println("内部类的成员变量age:" + this.age);
			System.out.println("内部类的局部成员变量age:" + age);
		}
	}

}