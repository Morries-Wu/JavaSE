package Java.Math.DataStructures;

public class maxSubseqSumBF {

	public static void main(String[] args) {
		System.out.println(maxSubseqSumByBF(new int[] { -5, 8, 12, -6, 8, -14 }));
	}
  //length	6	

	public static int maxSubseqSumByBF(int arr[]) {
		int length = arr.length;
		int maxSum = 0; // ������¼���ֵ
		for (int i = 0; i < length; i++) { // ���ѭ��ɨ���������������
			int nowSum = 0;
			for (int j = i; j < length; j++) { // ���ѭ��ɨ������е���i��ͷ����������
				nowSum = nowSum+arr[j];
				if (nowSum > maxSum) {
					maxSum = nowSum;
				}
			}
		}
		return maxSum;
	}

}
