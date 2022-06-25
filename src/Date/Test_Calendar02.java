package Date;

import java.text.*;
import java.util.*;

//可视化日历程序
public class Test_Calendar02 {
	public static void main(String[] args) throws ParseException {
		System.out.println("请输入日期（格式：2020-9-10）");
		Scanner str = new Scanner(System.in);
		String in = str.nextLine();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(in);
		Calendar c = new GregorianCalendar();  //设置日历
		c.setTime(date);                       //把日期传进去C的日历设置
		int day = c.get(Calendar.DAY_OF_MONTH); // 获取这个月的多少号
		int daymax = c.getActualMaximum(Calendar.DATE);
		
		
		
		System.out.println("日\t一\t二\t三\t四\t五\t六\t");
		c.set(Calendar.DAY_OF_MONTH, 1);
		for (int i = 0; i < c.get(Calendar.DAY_OF_WEEK)-1; i++) {// 获得本月实际天数
			System.out.print("\t");
		}
		

		for (int i = 1; i <= daymax; i++) {
			if (day == c.get(Calendar.DAY_OF_MONTH)) {
				System.out.print(c.get(Calendar.DAY_OF_MONTH) + "*\t");
			} else {
				System.out.print(c.get(Calendar.DAY_OF_MONTH) + "\t");
			}

			if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				System.out.println();// 换行
			}
			c.add(Calendar.DAY_OF_MONTH, 1);
		}
	}
}
