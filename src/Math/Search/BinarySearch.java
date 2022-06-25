package Java.Math.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//:使用二分查找的前提是该数组是有序的
public class BinarySearch {
	public static void main(String[] args) {
		int arr[] = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(binarySearch(arr, 0, arr.length - 1, 55));
	}

	// 二分查找算法
	public static int binarySearch(int arr[], int left, int right, int value) {
		System.out.println("------");
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		int midvalue = arr[mid];
		if (value > midvalue) { // 向右递归
			return binarySearch(arr, mid + 1, right, value);
		} else if (value < midvalue) {// 向左递归
			return binarySearch(arr, left, mid - 1, value);
		} else {
			return mid;
		}
	}

	// 完成一个课后思考题
	// 课后思考题：{1,8,10,89,100,100,123}当中有序数组中
	// 有多少个相同的数组时,如何将所有的数值都查找到,比如数组里边的100

	public static ArrayList<Integer> binarySearch2(int arr[], int left, int right, int value) {
		if (left > right) {
			return new ArrayList<Integer>(-1);
		}
		int mid = (left + right) / 2;
		int midvalue = arr[mid];
		if (value > midvalue) { // 向右递归
			return binarySearch2(arr, mid + 1, right, value);
		} else if (value < midvalue) {// 向左递归
			return binarySearch2(arr, left, mid - 1, value);
		} else {
			// 思路分析
			// 1.在找到mid索引值,不要马上返回
			// 2.向mid 索引值的左边扫描,将所有满足100的元素的下标,加入到集合ArrayList
			// 3.向mid 索引值的右边扫描,将所有满足100的元素的下标,加入到集合ArrayList
			ArrayList<Integer> resIndexlist = new ArrayList<Integer>();
			int temp = mid - 1;
			while (true) {
				if (temp < 0 || arr[temp] != value) {
					break;
				}
				// 否则,就把temp放入到resIndexlist
				resIndexlist.add(temp);
				temp--;// temp左移
			}
			resIndexlist.add(mid);
			temp = mid + 1;
			while (true) {
				if (temp > arr.length - 1 || arr[temp] != value) {
					break;
				}
				// 否则,就把temp放入到resIndexlist
				resIndexlist.add(temp);
				temp++;// temp右移
			}
			return resIndexlist;
		}
	}
}
