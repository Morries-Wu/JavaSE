package Inherit;

public class TestPolym {
	public static void main(String[] args) {
		Animal animal = new Animal();
		animalCry(animal);

		Animal d = new Dog(); // 向上转型
		animalCry(d);
		
		Animal c = new Cat(); // 向上转型
		animalCry(c);
		

//		Dog d2=(Dog) c;    不可以转换不同类型的向下转型，同类型才可以向下转型
//		d2.seeDoor();       
		
		Dog d2 = (Dog) d;    //向下转型
		d2.seeDoor();
	}
	
	static void animalCry(Animal animal) {
		animal.shout();
	}
}

class Animal {

	public void shout() {
		System.out.println("叫了一声！");
	}

}

class Dog extends Animal {
	public void shout() {
		System.out.println("汪汪汪！");
	}

	public void walk() {
		System.out.println("飞扑");
	}

	public void seeDoor() {
		System.out.println("看门！！！");
	}

}

class Cat extends Animal {
	public void shout() {
		System.out.println("喵喵喵！");

	}
}