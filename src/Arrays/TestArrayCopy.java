package Arrays;

import java.util.Arrays;

/*��������Ŀ���*/
public class TestArrayCopy {
	public static void main(String[] args) {
		String s1[] = { "aa", "bb", "cc", "dd", "ee" };
		removeElement(s1, 2);
		for (String i : s1) {
			System.out.println(i);
		}

		System.out.println("#############");
		s1 = extendRange(s1);
	}

	public static void testBasicCopy() {
		String s1[] = { "aa", "bb", "cc", "dd", "ee" };
		String s2[] = new String[10];
		System.arraycopy(s1, 2, s2, 6, 3);

		for (String i : s2) {
			System.out.println(i);
		}
	}


	/*���Դ�������ɾ��ĳ��Ԫ��(�����ϻ�������Ŀ���)*/
	public static void testBasicCopy2() {
		String s1[] = { "aa", "bb", "cc", "dd", "ee" };
		String s2[] = new String[s1.length - 1];

		System.arraycopy(s1, 3, s2, 2, 2);
		System.arraycopy(s1, 0, s2, 0, 2);
		System.arraycopy(s1, 3, s1, 2, 2);
		s1[s1.length - 1] = null;
		for (String i : s2) {
			System.out.println(i);
		}

		System.out.println("##########");
		for (int i = 0; i < s1.length; i++) {
			System.out.println(s1[i]);
		}
	}

	/*ɾ��������ָ������λ�õ�Ԫ��,����ԭ���鷵��*/
	public static String[] removeElement(String s[], int index) {
		System.arraycopy(s, index, s, index - 1, s.length - index);
		s[s.length - 1] = null;
		return s;
	}

	/*��������(��������;�ȶ���һ�����������,Ȼ��ԭ��������ԭ�ⲻ����������������)*/
	public static String[] extendRange(String s1[]) {
		String s2[] = new String[s1.length + 10];
		System.arraycopy(s1, 0, s2, 0, s1.length); /*��s1�����е�Ԫ�ؿ�����s2*/
		return s2;
	}

}
