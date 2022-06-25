package Server;

//反射:把java类中的各种结构(方法、属性、构造器、类名)映射成一个个的java对象
//1、获取Class对象
//三种方式:Class.forName("完整路径")
//2、可以动态创建对象 clz.getConstructor().newInstance();
public class ReflectTest {
	public static void main(String[] args) throws Exception {

		//拿到源三种方式

		// 1、对象.getClass()
		Iphone iphone = new Iphone();
		Class clz = iphone.getClass();

		// 2、类.class()
		clz = Iphone.class;

		// 3、Class.forName("包名.类名")
		clz = Class.forName("Server.Iphone");

		// 创建对象
		// Iphone iphone2 = (Iphone) clz.newInstance();// 不推荐已经过时了
		// System.out.println(iphone2);

		Iphone iphone3 = (Iphone) clz.getConstructor().newInstance();//推荐这种方式
		System.out.println(iphone3);

	}
}

class Iphone {
	public Iphone() {
	}
}
