package Date;

import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);

		// 以后遇到日期处理：使用Canlendar
		Date date2 = new Date(2020 - 1900, 11, 20);
		System.out.println(date2);
	}
}
