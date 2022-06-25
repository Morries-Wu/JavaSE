package Math.DataStructures;
//最长递增子序列
import java.util.Arrays;

public class maxAscendSequence {

	public static void main(String[] args) {
		int[] array = {10, -9,-2, 5, 3, 7, 101, 1, 18 };
		// 10, -9,-2, 5, 3, 7, 101, 1, 18
		int len = getLongthOfLIS(array);
		System.out.println(len);
	}

	private static int getLongthOfLIS(int[] array) {
		int[] dp = new int[array.length];
		dp[0] = 1;
		int result = 1;
		for (int i = 1; i < dp.length; i++) {
			int max = 1;// 局部变量max用于存储dp[i]上的最大值，最后再传递给dp[i]
			dp[i] = 1;// 所有dp[i]必须初始化为1，不然默认为0，然后输出的时候你就发现不对了
			for (int j = i; j >= 0; j--) {
				if (array[i] > array[j]) {
					dp[i] = dp[j] + 1;
					if (max < dp[i]) {
						max = dp[i];// 取出最大的dp[i] 
					}
				}
			}
			dp[i] = max;// 最后的时候进行赋值 
			if (result < dp[i]) {
				result = dp[i];// 这里直接有个全局变量，用于当作返回值  
			}
		}
		System.out.println(Arrays.toString(dp));// 输出数组，测试是否正确
		return result;
	}

}
