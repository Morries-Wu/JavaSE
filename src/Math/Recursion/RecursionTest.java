package Java.Math.Recursion;

public class RecursionTest {
	public static void main(String[] args) {
		int res = factorial(4);
		System.out.println(res);
	}

	// �ݹ���ù���:
	// 1.������ִ�е�һ������ʱ���ͻῪ��һ�������Ŀռ䣨ջ��
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
			//4.�ȵݹ鷵�ص������е�factorial(2 - 1),��1
			//5.���ص��������������ڶ���factorial(3 - 1),��2
			//6.���صڶ�������������һ��factorial(4 - 1)����6
			//7.����һ����4*6=24
		}
	}

}
