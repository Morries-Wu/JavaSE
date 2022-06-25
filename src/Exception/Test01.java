package Exception;

//Exception handling in test run time RuntimeException
//解决运行时异常，这类异常通常是由编程错误导致的,所以在编写程序时,并不要求必须使用异常处理机制来处理,经常需要通过增加“逻辑处理来避免异常”
public class Test01 {
	public static void main(String[] args) {
		int b = 0;
		int a = 1;
		if (b != 0) {
			System.out.println(a / b);
		}
		String str = null;
		if (str != null) {
			System.out.println(str.length());
		}
		Animal d = new Dog();
		if (d instanceof Cat) { // 左边对象是否是右边类的对象，若是返回true,否则返回false
			Cat c = (Cat) d;
		}

		int arr[] = new int[5];
		int t = 5;
		if (t < arr.length) {
			System.out.println(arr[t]);
		}

	}
}

class Animal {

}

class Dog extends Animal {

}

class Cat extends Animal {

}
