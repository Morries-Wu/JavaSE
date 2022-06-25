package Java.Math.Search;

import java.util.Arrays;

public class FibonacciSearch {

	public static int maxSize = 20;

	public static void main(String[] args) {
		int arr[] = { 1, 8, 10, 89, 1000, 1234 };
		System.out.println(fibSearch(arr, 1234));
	}

	// 因为后面我们mid=low+F(K-1)-1,需要使用到斐波那契额数列,因此我们需要先获取到一个斐波那契数列
	// 非递归方法得到一个斐波那契数列
	public static int[] fib() {
		int f[] = new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < maxSize; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		System.out.println(Arrays.toString(f));
		return f;
	}

	// 编写斐波那契查找算法
	// 使用非递归方法查找
	public static int fibSearch(int a[], int key) {
		int low = 0;
		int high = a.length - 1;
		int k = 0; // 表示斐波那契分割数值的下标
		int f[] = fib();
		int mid = 0;
		while (high > f[k] - 1) {
			k++;
		}
		// 因为f[k]值可能大于a的长度,因此我们需要使用Arrays类,构造一个新的数组,并指向temp[]

		// 不足的部分会使用0填充
		int temp[] = Arrays.copyOf(a, f[k]);
		System.out.println(Arrays.toString(temp));
		// 实际上需要使用a数组最后的数填充temp
		// 举例:temp={ 1, 8, 10, 89, 1000, 1234 ,0,0}=>
		// { 1, 8, 10, 89, 1000, 1234,1234,1234 }
		for (int i = high + 1; i < temp.length; i++) {
			temp[i] = a[high];
		}

		// 使用while来循环处理,找到我们的数key
		while (low <= high) {
			// 只要这个条件满足,就可以找
			mid = low + f[k - 1] - 1;
			if (key < temp[mid]) {
				// 我们应该继续向数组的前面查找(左边)
				// 1、全部元素=前面的元素+后边的元素
				// 2、f[k]=f[k-1]+f[k-2];
				// 因为前面f[k-1]个元素,所以可以继续拆分f[k-1]=f[k-2]+f[k-3]
				// 即在f[k-1]的前面继续查找 k = k - 1;
				// 即下次循环mid=low+f[f-1-1]-1
				high = mid - 1;
				k = k - 1;
			} else if (key > temp[mid]) {
				// 我们应该继续向数组的后面查找(右边)
				// 1、全部元素=前面的元素+后边的元素
				// 2、f[k]=f[k-1]+f[k-2];
				// 因为后面f[k-2]个元素,所以可以继续拆分f[k-2]=f[k-3]+f[k-4]
				// 即在f[k-2]的前面继续查找 k = k - 2;
				// 即下次循环mid=low+f[f-1-2]-1
				low = mid + 1;
				k = k - 2;
			} else {
				// 找到
				// 需要确定,返回的是哪个下标
				if (mid <= high) {
					// 斐波那契查找会在范围内返回mid
					return mid;
				} else {
					// 不在范围内返回high因为high之后都是赋值high下标数组值
					return high;
				}
			}

		}
		return -1;

	}

}
