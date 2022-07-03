package Arrays;

import java.util.Arrays;

/*测试数组存储表格数据*/
public class TestArraysTable {
	public static void main(String[] args) {
		Object emp1[] = { 1001, "祥哥", 18, "讲师", "2006.6.6" };
		Object emp2[] = { 1002, "祥哥2", 19, "程序员", "2016.6.6" };
		Object emp3[] = { 1003, "祥哥3", 10, "卖货", "2026.6.6" };

		Object tableDate[][] = new Object[3][];

		tableDate[0] = emp1;
		tableDate[1] = emp2;
		tableDate[2] = emp3;

		for (Object temp[] : tableDate) {
			System.out.println(Arrays.toString(temp));
		}
	}
}
