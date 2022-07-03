package Arrays;

import java.util.Arrays;

/*测试数组的拷贝*/
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


	/*测试从数组中删除某个元素(本质上还是数组的拷贝)*/
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

	/*删除数组中指定索引位置的元素,并将原数组返回*/
	public static String[] removeElement(String s[], int index) {
		System.arraycopy(s, index, s, index - 1, s.length - index);
		s[s.length - 1] = null;
		return s;
	}

	/*数组扩容(本质上是;先定义一个更大的数组,然后将原数组内容原封不动拷贝到新数组中)*/
	public static String[] extendRange(String s1[]) {
		String s2[] = new String[s1.length + 10];
		System.arraycopy(s1, 0, s2, 0, s1.length); /*将s1中所有的元素拷贝到s2*/
		return s2;
	}

}
