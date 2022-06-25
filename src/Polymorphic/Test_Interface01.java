package Polymorphic;

public class Test_Interface01 {
	public static void main(String[] args) {
		Volant v = new Angel();// 向上转型
		v.fly();

		Honest h = new GoodMan();
		h.helpOther();
	}
}

interface Volant {
	int FLY_HEIGHT = 1000;
	public abstract void fly();
}

interface Honest {
	public abstract void helpOther();
}

class Angel implements Volant, Honest { // 实现类可以实现多个父接口
	public void fly() {
		System.out.println("Angel.helpOther()");
	}
	public void helpOther() {
		System.out.println("Angel.fly()");
	}
}

class GoodMan implements Honest {
	public void helpOther() {
		System.out.println("GoodMan.helpOther()");
	}
}

class Birdman implements Volant {

	public void fly() {
		System.out.println("Angel.helpOther()");

	}
}
