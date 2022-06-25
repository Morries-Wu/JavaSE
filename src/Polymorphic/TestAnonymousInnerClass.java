package Polymorphic;

//测试匿名内部类
public class TestAnonymousInnerClass {

	public static void main(String[] args) {
		new AA() {
			@Override
			public void aa() {
				System.out.println("TestAnonymousInnerClass.main.interface.inner.AA()");
			}
		}.aa();
	}
}

interface AA {
	void aa();
}
