package Java.Math.Search;

import java.util.Arrays;

public class FibonacciSearch {

	public static int maxSize = 20;

	public static void main(String[] args) {
		int arr[] = { 1, 8, 10, 89, 1000, 1234 };
		System.out.println(fibSearch(arr, 1234));
	}

	// ��Ϊ��������mid=low+F(K-1)-1,��Ҫʹ�õ�쳲�����������,���������Ҫ�Ȼ�ȡ��һ��쳲���������
	// �ǵݹ鷽���õ�һ��쳲���������
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

	// ��д쳲����������㷨
	// ʹ�÷ǵݹ鷽������
	public static int fibSearch(int a[], int key) {
		int low = 0;
		int high = a.length - 1;
		int k = 0; // ��ʾ쳲������ָ���ֵ���±�
		int f[] = fib();
		int mid = 0;
		while (high > f[k] - 1) {
			k++;
		}
		// ��Ϊf[k]ֵ���ܴ���a�ĳ���,���������Ҫʹ��Arrays��,����һ���µ�����,��ָ��temp[]

		// ����Ĳ��ֻ�ʹ��0���
		int temp[] = Arrays.copyOf(a, f[k]);
		System.out.println(Arrays.toString(temp));
		// ʵ������Ҫʹ��a�������������temp
		// ����:temp={ 1, 8, 10, 89, 1000, 1234 ,0,0}=>
		// { 1, 8, 10, 89, 1000, 1234,1234,1234 }
		for (int i = high + 1; i < temp.length; i++) {
			temp[i] = a[high];
		}

		// ʹ��while��ѭ������,�ҵ����ǵ���key
		while (low <= high) {
			// ֻҪ�����������,�Ϳ�����
			mid = low + f[k - 1] - 1;
			if (key < temp[mid]) {
				// ����Ӧ�ü����������ǰ�����(���)
				// 1��ȫ��Ԫ��=ǰ���Ԫ��+��ߵ�Ԫ��
				// 2��f[k]=f[k-1]+f[k-2];
				// ��Ϊǰ��f[k-1]��Ԫ��,���Կ��Լ������f[k-1]=f[k-2]+f[k-3]
				// ����f[k-1]��ǰ��������� k = k - 1;
				// ���´�ѭ��mid=low+f[f-1-1]-1
				high = mid - 1;
				k = k - 1;
			} else if (key > temp[mid]) {
				// ����Ӧ�ü���������ĺ������(�ұ�)
				// 1��ȫ��Ԫ��=ǰ���Ԫ��+��ߵ�Ԫ��
				// 2��f[k]=f[k-1]+f[k-2];
				// ��Ϊ����f[k-2]��Ԫ��,���Կ��Լ������f[k-2]=f[k-3]+f[k-4]
				// ����f[k-2]��ǰ��������� k = k - 2;
				// ���´�ѭ��mid=low+f[f-1-2]-1
				low = mid + 1;
				k = k - 2;
			} else {
				// �ҵ�
				// ��Ҫȷ��,���ص����ĸ��±�
				if (mid <= high) {
					// 쳲��������һ��ڷ�Χ�ڷ���mid
					return mid;
				} else {
					// ���ڷ�Χ�ڷ���high��Ϊhigh֮���Ǹ�ֵhigh�±�����ֵ
					return high;
				}
			}

		}
		return -1;

	}

}
