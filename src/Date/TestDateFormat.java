package Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


//测试时间对象类和SimpleDateFormat实现类的使用
public class TestDateFormat {
	public static void main(String[] args) throws ParseException {
		// 把时间对象按照"格式字符串指定的格式"转换成相应的字符串
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		System.out.println(df.format(new Date()));

		// 把字符串按照"格式字符串指定的格式"转换成相应的时间对象
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
		Date date = df2.parse("1983年05月10日 10时45分59秒");
		System.out.println(date);
		System.out.println(new Date());
	}
}
