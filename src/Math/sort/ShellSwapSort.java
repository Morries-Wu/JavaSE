package Java.Math.sort;

import java.util.Arrays;

public class ShellSwapSort {
	public static void main(String[] args) {
		int arr[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		int temp = 0;
		int count = 0;
		// 希尔排序交换法
		for (int group = arr.length / 2; group > 0; group = group / 2) {
			for (int i = group; i < arr.length; i++) {
				for (int j = i - group; j >= 0; j = j - group) {
					// 如果当前元素大于加上步长后的那个元素,说明需要交换
					if (arr[j] > arr[j + group]) {
						temp = arr[j];
						arr[j] = arr[j + group];
						arr[j + group] = temp;
					}
				}
			}
			System.out.println("第" + count++ + "轮分组后的排序" + Arrays.toString(arr));
		}

//		// 希尔排序的第1轮排序
//		// 因为第1轮排序,是将10个数据分成5组
//		for (int i = 5; i < arr.length; i++) {
//			// 遍历各组中所有的元素(共五組,每組有2个元素)，步长5
//			for (int j = i - 5; j >= 0; j = j - 5) {
//				// 如果当前元素大于加上步长后的那个元素,说明需要交换
//				if (arr[j] > arr[j + 5]) {
//					temp = arr[j];
//					arr[j] = arr[j + 5];
//					arr[j + 5] = temp;
//				}
//			}
//		}
//		System.out.println("第一轮分组后的排序" + Arrays.toString(arr));
//
//		// 希尔排序的第2轮排序
//		// 因为第2轮排序,是将10个数据分成5/2=2组
//		for (int i = 2; i < arr.length; i++) {
//			// 遍历各组中所有的元素(共五組,每組有2个元素)，步长5
//			for (int j = i - 2; j >= 0; j = j - 2) {
//				// 如果当前元素大于加上步长后的那个元素,说明需要交换
//				if (arr[j] > arr[j + 2]) {
//					temp = arr[j];
//					arr[j] = arr[j + 2];
//					arr[j + 2] = temp;
//				}
//			}
//		}
//		System.out.println("第二轮分组后的排序" + Arrays.toString(arr));
//
//		// 希尔排序的第3轮排序
//		// 因为第3轮排序,是将10个数据分成2/2=1组
//		for (int i = 1; i < arr.length; i++) {
//			// 遍历各组中所有的元素(共五組,每組有2个元素)，步长5
//			for (int j = i - 1; j >= 0; j = j - 1) {
//				// 如果当前元素大于加上步长后的那个元素,说明需要交换
//				if (arr[j] > arr[j + 1]) {
//					temp = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = temp;
//				}
//			}
//		}
//		System.out.println("第三轮分组后的排序" + Arrays.toString(arr));

	}
}
