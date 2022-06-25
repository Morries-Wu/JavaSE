package Java.Math.sort;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int arr[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		int temp = 0;// 临时变量
		boolean flag = false;// 标识变量,表示是否进行交换
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if (flag != true) {
				break;
			} else {
				flag = false;
			}
			System.out.println(Arrays.toString(arr));
		}
	}
}
