package Arrays;

import java.util.Arrays;
import java.util.Iterator;

//≤‚ ‘√∞≈›≈≈–Ú
public class TestBubbleSort {

	public static void main(String[] args) {
		int values[] = { 3, 1, 6, 2, 9, 7, 4, 5, 8 };
		System.out.println(Arrays.toString(BubbleSort(values)));

	}

	public static int[] BubbleSort(int arr[]) {

		boolean flag = false;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					int temp = 0;
					temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
			if (flag == true)
				flag = false;
		}
		return arr;
	}

}
