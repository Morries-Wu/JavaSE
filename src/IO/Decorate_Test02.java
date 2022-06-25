package IO;

//ģ�⿧��
//1.�������:��Ҫװ�εĳ������(�ӿڻ������)
//2.�������:��Ҫװ�εĶ���
//3.����װ����:�ڲ������˶Գ�������������Լ�װ���Ź��еķ���
//4.����װ����:��װ�εĶ���
public class Decorate_Test02 {

	public static void main(String[] args) {
		Drink coffee = new Coffee();
		Drink suger = new Suger(coffee);
		System.out.println(suger.information() + "-------" + suger.cost());
		Drink milk = new Milk(suger);
		System.out.println(milk.information() + "-------" + milk.cost());
	}
}

//�������
interface Drink {
	double cost();// ����

	String information();// ��Ϣ˵��
}

//�������
class Coffee implements Drink {

	private String name = "ԭζ����";

	public double cost() {
		return 10;
	}

	public String information() {
		return name;
	}
}

//����װ����
abstract class Decorate implements Drink {
	// �Գ������������
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

//����װ����
class Milk extends Decorate {

	public Milk(Drink drink) {
		super(drink);
	}

	public double cost() {
		return super.cost() * 4;
	}

	public String information() {
		return super.information() + "������ţ��";
	} 

}

//����װ����
class Suger extends Decorate {

	public Suger(Drink drink) {
		super(drink);
	}

	public double cost() {
		return super.cost() * 2;
	}

	public String information() {
		return super.information() + "����������";
	}

}
