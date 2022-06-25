package Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


//����ʱ��������SimpleDateFormatʵ�����ʹ��
public class TestDateFormat {
	public static void main(String[] args) throws ParseException {
		// ��ʱ�������"��ʽ�ַ���ָ���ĸ�ʽ"ת������Ӧ���ַ���
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		System.out.println(df.format(new Date()));

		// ���ַ�������"��ʽ�ַ���ָ���ĸ�ʽ"ת������Ӧ��ʱ�����
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
		Date date = df2.parse("1983��05��10�� 10ʱ45��59��");
		System.out.println(date);
		System.out.println(new Date());
	}
}
