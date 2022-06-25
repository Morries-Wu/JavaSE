package Arrays;

import java.util.Arrays;

public class TestArrays {
	public static void main(String[] args) {
		int a[] = { 10, 20, 30, 200, 310, 415, 752, 315 };
		System.out.println(a);
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.binarySearch(a, 310));
	}
}
