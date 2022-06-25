package Arrays;

public class Test2DimensionArray {
	public static void main(String[] args) {
		int a[][] = new int[3][];
		a[0] = new int[] { 20, 30 };
		a[1] = new int[] { 10, 15, 90 };
		a[2] = new int[] { 50, 60 };

		for (int i : a[0]) {
			System.out.println(i);
		}

		// 静态初始化二维数组
		int b[][] = { { 20, 30, 40 }, { 50, 20 }, { 100, 200, 300, 400 } };
	

	}
}
