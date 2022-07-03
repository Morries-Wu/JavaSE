package Polymorphic;


public interface MyInterface {
	int MAX_AGE = 100; // maxage==public static final int MAX_AGE=100;

	public abstract void test01(); // 接口里面不存在什么私有
}

class Myclass implements MyInterface {// 想要实现接口就要实现接口里面的抽象方法

	@Override
	public void test01() {
		System.out.println(MAX_AGE);
		System.out.println("MyClass.test01()");
	}

}
