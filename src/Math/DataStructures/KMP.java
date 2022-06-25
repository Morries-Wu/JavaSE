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
		// 遍历
		for (int i = 0, j = 0; i < str1.length(); i++) {
			// 需要处理str1.charAt(i)!=str2.charAt(j),去调整j的大小
			// KMP算法核心点
			while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
				j = next[j - 1];
			}

			if (str1.charAt(i) == str2.charAt(j)) {//比较对象！
				j++;
			}

			if (j == str2.length()) {
				return i - j + 1;
			}

		}
		return -1;
	}

	// 获取到字符串(字串)的部分匹配值
	public static int[] kmpNext(String dest) {

		// 创建一个next数组保存部分匹配值
		int next[] = new int[dest.length()];
		next[0] = 0;// 如果字符串是长度为1部分匹配值就是0
		for (int i = 1, j = 0; i < next.length; i++) {
			// 当dest.charAt(i) ！= dest.charAt(j),我们需要从next[j-1]获取新的J
			// 直到我们发现有dest.charAt(i) == dest.charAt(j)成立才退出
			while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
				j = next[j - 1];
			}

			if (dest.charAt(i) == dest.charAt(j)) {
				// 当条件满足时,部分匹配值就+1
				j++;
			}
			next[i] = j;
		}
		return next;
	}

}



