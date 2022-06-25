package Inherit;

public class TestPolym {
	public static void main(String[] args) {
		Animal animal = new Animal();
		animalCry(animal);

		Animal d = new Dog(); // ����ת��
		animalCry(d);
		
		Animal c = new Cat(); // ����ת��
		animalCry(c);
		

//		Dog d2=(Dog) c;    ������ת����ͬ���͵�����ת�ͣ�ͬ���Ͳſ�������ת��
//		d2.seeDoor();       
		
		Dog d2 = (Dog) d;    //����ת��
		d2.seeDoor();
	}
	
	static void animalCry(Animal animal) {
		animal.shout();
	}
}

class Animal {

	public void shout() {
		System.out.println("����һ����");
	}

}

class Dog extends Animal {
	public void shout() {
		System.out.println("��������");
	}

	public void walk() {
		System.out.println("����");
	}

	public void seeDoor() {
		System.out.println("���ţ�����");
	}

}

class Cat extends Animal {
	public void shout() {
		System.out.println("��������");

	}
}