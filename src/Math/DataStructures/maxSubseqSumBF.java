package Java.Math.DataStructures;

public class maxSubseqSumBF {

	public static void main(String[] args) {
		System.out.println(maxSubseqSumByBF(new int[] { -5, 8, 12, -6, 8, -14 }));
	}
  //length	6	

	public static int maxSubseqSumByBF(int arr[]) {
		int length = arr.length;
		int maxSum = 0; // 用来记录最大值
		for (int i = 0; i < length; i++) { // 这个循环扫描出所有连续序列
			int nowSum = 0;
			for (int j = i; j < length; j++) { // 这个循环扫描出所有的以i开头的连续序列
				nowSum = nowSum+arr[j];
				if (nowSum > maxSum) {
					maxSum = nowSum;
				}
			}
		}
		return maxSum;
	}

}
