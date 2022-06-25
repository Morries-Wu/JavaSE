package Math.DataStructures;

import java.util.Arrays;

public class KMP {
	public static void main(String[] args) {
		String str1 = "BBC ABCDAB ABCDABABABDE";
		String str2 = "ABAB";
		int next[] = kmpNext(str2);
		System.out.println(Arrays.toString(next));

		int index = kmpsearch(str1, str2, next);
		System.out.println(index);

	}

	public static int kmpsearch(String str1, String str2, int next[]) {
		// ����
		for (int i = 0, j = 0; i < str1.length(); i++) {
			// ��Ҫ����str1.charAt(i)!=str2.charAt(j),ȥ����j�Ĵ�С
			// KMP�㷨���ĵ�
			while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
				j = next[j - 1];
			}

			if (str1.charAt(i) == str2.charAt(j)) {//�Ƚ϶���
				j++;
			}

			if (j == str2.length()) {
				return i - j + 1;
			}

		}
		return -1;
	}

	// ��ȡ���ַ���(�ִ�)�Ĳ���ƥ��ֵ
	public static int[] kmpNext(String dest) {

		// ����һ��next���鱣�沿��ƥ��ֵ
		int next[] = new int[dest.length()];
		next[0] = 0;// ����ַ����ǳ���Ϊ1����ƥ��ֵ����0
		for (int i = 1, j = 0; i < next.length; i++) {
			// ��dest.charAt(i) ��= dest.charAt(j),������Ҫ��next[j-1]��ȡ�µ�J
			// ֱ�����Ƿ�����dest.charAt(i) == dest.charAt(j)�������˳�
			while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
				j = next[j - 1];
			}

			if (dest.charAt(i) == dest.charAt(j)) {
				// ����������ʱ,����ƥ��ֵ��+1
				j++;
			}
			next[i] = j;
		}
		return next;
	}

}



