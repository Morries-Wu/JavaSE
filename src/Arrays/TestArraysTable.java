package Arrays;

import java.util.Arrays;

/*��������洢�������*/
public class TestArraysTable {
	public static void main(String[] args) {
		Object emp1[] = { 1001, "���", 18, "��ʦ", "2006.6.6" };
		Object emp2[] = { 1002, "���2", 19, "����Ա", "2016.6.6" };
		Object emp3[] = { 1003, "���3", 10, "����", "2026.6.6" };

		Object tableDate[][] = new Object[3][];

		tableDate[0] = emp1;
		tableDate[1] = emp2;
		tableDate[2] = emp3;

		for (Object temp[] : tableDate) {
			System.out.println(Arrays.toString(temp));
		}
	}
}
