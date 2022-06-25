package Thread;


//Lambda推导+参数+返回值
public class Lambda_Test03 {
	public static void main(String[] args) {
		IInterest interest = (int a, int b) -> {
			System.out.println("i like 	lambda----" + (a + b));
			return a + b;
		};
		interest.lambda(100, 200);

		interest = (a, b) -> {
			System.out.println("i like 	lambda----" + (a + b));
			return a + b;
		};
		interest.lambda(200, 300);

		interest = (a, b) -> {
			return a + b;
		};
		interest.lambda(300, 400);

		interest = (a, b) -> a + b;
		System.out.println(interest.lambda(300, 400));
	}
}

interface IInterest {
	int lambda(int a, int b);
}

//外部类
class Interest implements IInterest {

	public int lambda(int a, int b) {
		System.out.println("i like 	lambda----" + (a + b));
		return a + b;
	}

}
