package Date;

import java.util.Calendar;
import java.util.GregorianCalendar;

//�����������ʹ��
public class Test_Calendar01 {
	public static void main(String[] args) {
		// ������ڵ����Ԫ��
		Calendar calendar = new GregorianCalendar();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);
		int day = calendar.get(Calendar.DATE);
		System.out.println(year);
		System.out.println(month);// 0-11��ʾ��Ӧ���·ݡ�0��1�£�1����2��.........11����12��
		System.out.println(weekday); // ���ڼ���1-7 1��������,2����һ..............
		System.out.println(day); // ���ڼ���1-7 1��������,2����һ..............

		// �������ڵ����Ԫ��
		GregorianCalendar c2 = new GregorianCalendar();
		c2.set(Calendar.YEAR, 8012);
		System.out.println(c2.YEAR);
	 
		// ���ڼ���
		Calendar c3 = new GregorianCalendar();
		c3.add(Calendar.DATE, 100);

	}
}
