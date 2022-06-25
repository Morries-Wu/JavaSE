package Java.Math.DataStructures;
//最大公共子序列
public class Solution {
	public static int[][] longestCommonSubsequence(String str1, String str2) {
		int row = str1.length();
		int col = str2.length();
		int dp[][] = new int[row + 1][col + 1];
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				char c1 = str1.charAt(i - 1);
				char c2 = str2.charAt(j - 1);
				if (c1 == c2) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp;
	}

	public static void main(String[] args) {

		int dp[][] = longestCommonSubsequence("acagmcd", "abcca");
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + "  ");
			}
			System.out.println();
		}
	}

}
