package Mycollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Collections������(������)��ʹ��
//Collection�ǽӿڣ�Collections�ǹ�����
public class TestCollections {
	public static void main(String[] args) {
		List list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add("Morries" + i);
		}
		System.out.println(list);
		Collections.shuffle(list); // �������list�е�Ԫ��
		System.out.println(list);
		Collections.reverse(list); // ��������
		System.out.println(list);
		Collections.sort(list); // ���յ�����ʽ����,�Զ������ʹ�ã�Comparable�ӿ�
		System.out.println(list);
		System.out.println(Collections.binarySearch(list, "Morries1"));//���ַ�����
	}
}
