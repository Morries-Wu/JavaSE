package Arrays;

import java.time.chrono.MinguoChronology;
import java.util.Arrays;

//测试二分法查找（这般检索）
public class TestBinarySearch {
	public static void main(String[] args) {

		int arr[] = { 30, 20, 50, 10, 80, 9, 7, 12, 100, 40, 8 };
		Arrays.sort(arr); // 排序从小到大
		System.out.println(Arrays.toString(arr));
		int value = 8; // 要查找的值！
		System.out.println(myBinarySearch2(arr, value, 0, arr.length - 1));
//		int left = 0;
//		int right = arr.length - 1;
	}

	public static int myBinarySearch1(int arr[], int value) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (value == arr[mid])
				return mid;
			if (value > arr[mid])
				left = mid + 1;
			if (value < arr[mid])
				right = mid - 1;
		}
		return -1;
	}

	public static int myBinarySearch2(int arr[], int value, int left, int right) {
		int mid = (left + right) / 2;
		if (left <= right) {
			if (value == arr[mid]) {
				return mid;
			}
			if (value > arr[mid]) {
				return myBinarySearch2(arr, value, mid + 1, right);
			}
			if (value < arr[mid]) {
				return myBinarySearch2(arr, value, left, mid - 1);
			}
		}
		return -1;
	}
}
