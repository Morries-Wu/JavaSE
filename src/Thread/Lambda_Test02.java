package Thread;

import org.w3c.dom.ls.LSOutput;

//Lambda推导
public class Lambda_Test02 {
	public static void main(String[] args) {
		ILOVE love = (int a) -> {
			System.out.println("I like lambda" + a);
		};
		love.lambda(5);

		// 简化
		love = (a) -> {
			System.out.println("I like lambda" + a);
		};
		love.lambda(50);

		love = a -> {
			System.out.println("I like lambda" + a);
		};
		love.lambda(500);
		
		
		love = a -> System.out.println("I like lambda" + a);
		love.lambda(5000);
	}
}

interface ILOVE {
	void lambda(int a);
}

//外部类
class lOVE implements ILOVE {

	@Override
	public void lambda(int a) {
		System.out.println("I like lambda" + a);
	}

}