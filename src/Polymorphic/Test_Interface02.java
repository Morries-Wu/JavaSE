package Polymorphic;

public class Test_Interface02 {

}

interface A {
	void TestA();
}

interface B {
	void TestB();
}

interface C extends A, B {
	public abstract void TestC();
}

class Test implements C {

	public void TestA() {
		System.out.println("TestA");
	}

	public void TestB() {
		System.out.println("TestB");
	}

	public void TestC() {
		System.out.println("TestC");
	}
}