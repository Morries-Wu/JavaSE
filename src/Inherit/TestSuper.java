package Inherit;

public class TestSuper {
	public static void main(String[] args) {
		new ChildClass().f();
	}
}

class FatherClass {
	public int value;
	public void f() {
		value = 100;
		System.out.println("FatherClass.value=" + value);
	}

}

class ChildClass extends FatherClass {
	public int value;
	public void f() {
		super.f();
		value = 200;
		System.out.println("childclass.value=" + value);
		System.out.println(value);
		System.out.println(super.value);// ���ø������ĳ�Ա����
	}

}