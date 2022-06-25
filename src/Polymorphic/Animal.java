package Polymorphic;

abstract public class Animal {

	// 第一:没有实现
	// 第二:子类必须实现
	abstract public void shout();

	public void run() {
		System.out.println("跑啊！");
	}

	public static void main(String[] args) {
		Animal a = new Dog();
		a.shout();
		a.run();
	}

}

class Dog extends Animal {

	public void shout() {
		System.out.println("狗叫！");

	}

}