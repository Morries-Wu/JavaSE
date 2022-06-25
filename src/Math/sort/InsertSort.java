package Java.Math.sort;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		int arr[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		System.out.println(Arrays.toString(arr)+"\n\n\n\n");
		
		int indexValue = 0;
		int insertIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			indexValue = arr[i];
			insertIndex = i - 1;
			while (insertIndex >= 0 && indexValue < arr[insertIndex]) {
				arr[insertIndex + 1] = arr[insertIndex];
				insertIndex--;
			}
			arr[insertIndex + 1] = indexValue;
			System.out.println(Arrays.toString(arr));
		}
	}
	
}
