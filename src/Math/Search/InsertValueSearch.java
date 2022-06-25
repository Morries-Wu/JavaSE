package Java.Math.Search;

import java.util.Arrays;

//对于数据量大,关键字分布比较均匀的查找来说,采用插值查找,速度比较快
//关键字分布不均匀的情况下,该方法不一定比折半查找要好
public class InsertValueSearch {
	public static void main(String[] args) {
		int arr[] = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		System.out.println(Arrays.toString(arr));

		System.out.println(inserValueSearch(arr, 0, arr.length - 1, 55));
	}

	// 编写插值查找算法
	public static int inserValueSearch(int arr[], int left, int right, int value) {
		System.out.println("------");
		// 注意:value<arr[0]和value>arr[arr.length-1]必须需要
		// 否则我们得到的mid可能越界
		if (left > right || value > arr[arr.length - 1] || value < arr[0]) {
			return -1;
		}
		// 求出mid
		int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
		int midvalue = arr[mid];
		if (value > midvalue) {// 说明应该向右边递归
			inserValueSearch(arr, mid + 1, right, midvalue);
		} else if (value < midvalue) {
			inserValueSearch(arr, mid - 1, right, midvalue);
		} else {
			return mid;
		}
		return mid;
	}

}
