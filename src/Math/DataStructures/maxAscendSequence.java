package Math.DataStructures;
//�����������
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
			int max = 1;// �ֲ�����max���ڴ洢dp[i]�ϵ����ֵ������ٴ��ݸ�dp[i]
			dp[i] = 1;// ����dp[i]�����ʼ��Ϊ1����ȻĬ��Ϊ0��Ȼ�������ʱ����ͷ��ֲ�����
			for (int j = i; j >= 0; j--) {
				if (array[i] > array[j]) {
					dp[i] = dp[j] + 1;
					if (max < dp[i]) {
						max = dp[i];// ȡ������dp[i] 
					}
				}
			}
			dp[i] = max;// ����ʱ����и�ֵ 
			if (result < dp[i]) {
				result = dp[i];// ����ֱ���и�ȫ�ֱ��������ڵ�������ֵ  
			}
		}
		System.out.println(Arrays.toString(dp));// ������飬�����Ƿ���ȷ
		return result;
	}

}
