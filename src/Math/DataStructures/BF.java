package Math.DataStructures;

public class BF {

	public static void main(String[] args) {
		System.out.println(BF("accabdsabcdesasata", "abc", 0));
	}

	public static int BF(String str, String sub, int pos) {
		// ��ȫ��У��
		if (pos < 0 || pos > str.length()) {
			return -1;
		}
		// �ֱ���������Ӵ�����ָ��
		int strIndex = pos;
		int subIndex = 0;
		while (strIndex < str.length() && subIndex < sub.length()) {
			if (str.charAt(strIndex) == sub.charAt(subIndex)) {
				// ���ƥ�����˾ͼ�������ƥ��
				strIndex++;
				subIndex++;
			} else {
				// strָ����ˣ�����+1����һ����ʼ����ƥ��
				strIndex = strIndex - subIndex + 1;
				subIndex = 0;
			}
		}
		// ƥ�����˷��ض�Ӧλ��
		if (subIndex >= sub.length()) {
			return strIndex - subIndex;
		}
		// ûƥ���Ϸ���-1
		return -1;
	}
}
