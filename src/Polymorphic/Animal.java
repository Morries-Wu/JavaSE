package Polymorphic;

abstract public class Animal {

	// ��һ:û��ʵ��
	// �ڶ�:�������ʵ��
	abstract public void shout();

	public void run() {
		System.out.println("�ܰ���");
	}

	public static void main(String[] args) {
		Animal a = new Dog();
		a.shout();
		a.run();
	}

}

class Dog extends Animal {

	public void shout() {
		System.out.println("���У�");

	}

}