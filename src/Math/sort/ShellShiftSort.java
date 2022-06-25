package Java.Math.sort;

import java.util.Arrays;

public class ShellShiftSort {
	public static void main(String[] args) {
		int arr[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		System.out.println(Arrays.toString(arr));
		int indexValue = 0;
		int insertIndex = 0;
		int count = 0;
		// 增量group,并逐步的缩小增量
		// 移位希尔排序
		for (int group = arr.length / 2; group >0; group = group / 2) {
			// 从第group个元素开始，逐个对其所在的组进行直接插入排序
			for (int i = group; i < arr.length; i++) {
				insertIndex = i;
				indexValue = arr[insertIndex];
				while (insertIndex - group >= 0 && indexValue < arr[insertIndex - group]) {
					// 移动
					arr[insertIndex] = arr[insertIndex - group];
					insertIndex = insertIndex - group;
				}
				// 当退出循环后,就给temp找到插入的位置
				arr[insertIndex] = indexValue;
			}
			System.out.println("第" + count++ + "轮分组后的排序" + Arrays.toString(arr));
		}
	}

}
