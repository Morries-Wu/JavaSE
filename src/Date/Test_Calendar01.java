package Date;

import java.util.Calendar;
import java.util.GregorianCalendar;

//测试日期类的使用
public class Test_Calendar01 {
	public static void main(String[] args) {
		// 获得日期的相关元素
		Calendar calendar = new GregorianCalendar();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);
		int day = calendar.get(Calendar.DATE);
		System.out.println(year);
		System.out.println(month);// 0-11表示对应的月份。0是1月，1月是2月.........11月是12月
		System.out.println(weekday); // 星期几。1-7 1：星期日,2星期一..............
		System.out.println(day); // 星期几。1-7 1：星期日,2星期一..............

		// 设置日期的相关元素
		GregorianCalendar c2 = new GregorianCalendar();
		c2.set(Calendar.YEAR, 8012);
		System.out.println(c2.YEAR);
	 
		// 日期计算
		Calendar c3 = new GregorianCalendar();
		c3.add(Calendar.DATE, 100);

	}
}
