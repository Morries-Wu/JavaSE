package Java.Math.Recursion;

public class RecursionTest {
	public static void main(String[] args) {
		int res = factorial(4);
		System.out.println(res);
	}

	// 递归调用规则:
	// 1.当程序执行到一个方法时，就会开辟一个独立的空间（栈）
	public static void test(int n) {
		if (n > 2) {
			test(n - 1);
		}
		System.out.println("n=" + n);
	}

	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return factorial(n - 1) * n;
			//1.factorial(4 - 1) * 4
			//2.factorial(3 - 1) * 3
			//3.factorial(2 - 1) * 2
			//4.先递归返回第三步中的factorial(2 - 1),即1
			//5.返回第三步计算结果到第二步factorial(3 - 1),即2
			//6.返回第二步计算结果到第一步factorial(4 - 1)，即6
			//7.最后第一步中4*6=24
		}
	}

}
