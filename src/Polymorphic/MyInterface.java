package Polymorphic;


public interface MyInterface {
	int MAX_AGE = 100; // maxage==public static final int MAX_AGE=100;

	public abstract void test01(); // �ӿ����治����ʲô˽��
}

class Myclass implements MyInterface {// ��Ҫʵ�ֽӿھ�Ҫʵ�ֽӿ�����ĳ��󷽷�

	@Override
	public void test01() {
		System.out.println(MAX_AGE);
		System.out.println("MyClass.test01()");
	}

}
