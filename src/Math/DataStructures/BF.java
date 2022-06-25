package Math.DataStructures;

public class BF {

	public static void main(String[] args) {
		System.out.println(BF("accabdsabcdesasata", "abc", 0));
	}

	public static int BF(String str, String sub, int pos) {
		// 安全性校验
		if (pos < 0 || pos > str.length()) {
			return -1;
		}
		// 分别给主串和子串定义指针
		int strIndex = pos;
		int subIndex = 0;
		while (strIndex < str.length() && subIndex < sub.length()) {
			if (str.charAt(strIndex) == sub.charAt(subIndex)) {
				// 如果匹配上了就继续往后匹配
				strIndex++;
				subIndex++;
			} else {
				// str指针回退，并且+1从下一个开始继续匹配
				strIndex = strIndex - subIndex + 1;
				subIndex = 0;
			}
		}
		// 匹配上了返回对应位置
		if (subIndex >= sub.length()) {
			return strIndex - subIndex;
		}
		// 没匹配上返回-1
		return -1;
	}
}
