package IO;

//模拟咖啡
//1.抽象组件:需要装饰的抽象对象(接口或抽象父类)
//2.具体组件:需要装饰的对象
//3.抽象装饰类:内部包含了对抽象组件的引用以及装饰着共有的方法
//4.具体装饰类:被装饰的对象
public class Decorate_Test02 {

	public static void main(String[] args) {
		Drink coffee = new Coffee();
		Drink suger = new Suger(coffee);
		System.out.println(suger.information() + "-------" + suger.cost());
		Drink milk = new Milk(suger);
		System.out.println(milk.information() + "-------" + milk.cost());
	}
}

//抽象组件
interface Drink {
	double cost();// 费用

	String information();// 信息说明
}

//具体组件
class Coffee implements Drink {

	private String name = "原味咖啡";

	public double cost() {
		return 10;
	}

	public String information() {
		return name;
	}
}

//抽象装饰类
abstract class Decorate implements Drink {
	// 对抽象组件的引用
	private Drink drink;

	public Decorate(Drink drink) {
		this.drink = drink;
	}

	public double cost() {
		return this.drink.cost();
	}

	public String information() {
		return this.drink.information();
	}

}

//具体装饰类
class Milk extends Decorate {

	public Milk(Drink drink) {
		super(drink);
	}

	public double cost() {
		return super.cost() * 4;
	}

	public String information() {
		return super.information() + "加入了牛奶";
	} 

}

//具体装饰类
class Suger extends Decorate {

	public Suger(Drink drink) {
		super(drink);
	}

	public double cost() {
		return super.cost() * 2;
	}

	public String information() {
		return super.information() + "加入了蔗糖";
	}

}
