package Mycollection;

import java.util.*;;

//����Map��ʹ��
public class Test_Map01 {
	public static void main(String[] args) {

		// �����ظ������ظ�����д��ֵ
		Map<Integer, String> m = new HashMap<>();
		m.put(1, "one");// 1Ҳ�Ǹ����󣬡�one���ַ�������
		m.put(2, "two");
		m.put(3, "three");
		System.out.println(m.get(1));

		System.out.println(m.size());
		System.out.println(m.isEmpty());
		System.out.println(m.containsKey(2));
		System.out.println(m.containsValue("6"));
		System.out.println();
		System.out.println();
		Map<Integer, String> m2 = new HashMap<>();
		m.put(4, "one");// 1Ҳ�Ǹ����󣬡�one���ַ�������
		m.put(5, "two");
		m.putAll(m2);
		System.out.println(m);
		// map�м������ظ�(�Ƿ��ظ��Ǹ���equals�������ж�)�����µĸ��Ǿɵ�
		m.put(3, "ɵ��");
		System.out.println(m);
	}
}
