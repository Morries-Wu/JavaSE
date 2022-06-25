package Java.Math.Recursion;

public class Queue8 {

	// 定义一个max表示共有多少个皇后
	int max = 8;
	int array[] = new int[max];
	int count = 0;
	int jugdeCount = 0;

	// 定义数组array,保存皇后放置位置结果，比如array={0,4,7,5,2,6,1,3}
	public static void main(String[] args) {
		Queue8 queue8 = new Queue8();
		queue8.check(0);
		System.out.println(queue8.count);
		System.out.println(queue8.jugdeCount);
	}

	// 编写一个方法,放置第n个皇后
	// 特别注意：check 是每一次递归时，进入到check中都有 for (int i = 0; i < max; i++)
	private void check(int n) {
		if (n == max) { // n=8,其实8个皇后已经放好了
			print();
			count++;
			return;
		}

		// 依次放入皇后，并判断是否冲突
		for (int i = 0; i < max; i++) {
			jugdeCount++;
			// 先把当前这个皇后 n，放到该行的第1列
			array[n] = i;
			// 判断当放置第n个皇后 到i列时，是否冲突
			if (judge(n) == true) {// 不冲突,接着放n+1个皇后,即开始递归
				check(n + 1);
			}
			// 如果冲突,就继续执行array[n] = i，即将第n个皇后，放置在本行的后移的一个位置
		}
	}

	// 查看当我们放置第n个皇后，就去检测该皇后是否和前面已经拜访的皇后冲突
	/**
	 * 
	 * @param n 表示第n个皇后
	 * @return
	 */
	private boolean judge(int n) {
		for (int i = 0; i < n; i++) {
			// 1.array[i] == array[n] 表示判断 第n个皇后是否和前面的n-1个皇后在同一列
			// 2.Math.abs(n - i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i皇后是否在同一斜线
			if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}

	// 写一个方法,可以将皇后摆放的位置输出
	private void print() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();

		int temp[][] = new int[max][max];
		for (int i = 0; i < temp.length; i++) {
			temp[i][array[i]] = 1;
		}

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

}
