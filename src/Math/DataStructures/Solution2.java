package Java.Math.DataStructures;

import java.util.Arrays;
import java.util.Iterator;
//最长递增子序列
public class Solution2 {

	public static void main(String[] args) {
		int[] array = { 10, -9, -2, 5, 3, 7, 101, 1, 18 };
		// 10, -9,-2, 5, 3, 7, 101, 1, 18
		int len = getHeight(array);
		System.out.println(len);
	}

	public static int getHeight(int arr[]) {
		int dp[] = new int[arr.length];
		if (arr.length == 1) {
			return 1;
		}
		Arrays.fill(dp, 1);
		int ret = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);  
				}
			}
			ret = Math.max(dp[i], ret);
		}
		return ret;
	}
}
