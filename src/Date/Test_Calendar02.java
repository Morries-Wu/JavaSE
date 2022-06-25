package Date;

import java.text.*;
import java.util.*;

//���ӻ���������
public class Test_Calendar02 {
	public static void main(String[] args) throws ParseException {
		System.out.println("���������ڣ���ʽ��2020-9-10��");
		Scanner str = new Scanner(System.in);
		String in = str.nextLine();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(in);
		Calendar c = new GregorianCalendar();  //��������
		c.setTime(date);                       //�����ڴ���ȥC����������
		int day = c.get(Calendar.DAY_OF_MONTH); // ��ȡ����µĶ��ٺ�
		int daymax = c.getActualMaximum(Calendar.DATE);
		
		
		
		System.out.println("��\tһ\t��\t��\t��\t��\t��\t");
		c.set(Calendar.DAY_OF_MONTH, 1);
		for (int i = 0; i < c.get(Calendar.DAY_OF_WEEK)-1; i++) {// ��ñ���ʵ������
			System.out.print("\t");
		}
		

		for (int i = 1; i <= daymax; i++) {
			if (day == c.get(Calendar.DAY_OF_MONTH)) {
				System.out.print(c.get(Calendar.DAY_OF_MONTH) + "*\t");
			} else {
				System.out.print(c.get(Calendar.DAY_OF_MONTH) + "\t");
			}

			if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				System.out.println();// ����
			}
			c.add(Calendar.DAY_OF_MONTH, 1);
		}
	}
}
