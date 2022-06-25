package Thread;

//Lambda推导
//lambda表达式是用于接口实现
public class Lambda_Test01 {
	// 静态内部类
	static class Like2 implements ILike {
		public void lambda() {
			System.out.println("I like lambda2");
		}
	}



	public static void main(String[] args) {
		ILike like = new Like();
		like.lambda();

		like = new Like2();
		like.lambda();

		class Like3 implements ILike {
			public void lambda() {
				System.out.println("I like lambda3");
			}
		}
		like = new Like3();
		like.lambda();

		// 匿名内部类
		like = new ILike() {
			public void lambda() {
				System.out.println("i like lambda4");
			}
		};
		like.lambda();

		// lambda
		like = () -> {
			System.out.println("i like lambda5");
		};
		like.lambda();
	}
}

interface ILike {
	void lambda();
}

//外部类
class Like implements ILike {
	@Override
	public void lambda() {
		System.out.println("I like lambda1");
	}

}
