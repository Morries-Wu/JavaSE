package Exception;

//Exception handling in test run time RuntimeException
//�������ʱ�쳣�������쳣ͨ�����ɱ�̴����µ�,�����ڱ�д����ʱ,����Ҫ�����ʹ���쳣�������������,������Ҫͨ�����ӡ��߼������������쳣��
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
		if (d instanceof Cat) { // ��߶����Ƿ����ұ���Ķ������Ƿ���true,���򷵻�false
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
