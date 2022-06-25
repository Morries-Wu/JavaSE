package BOX;

public class TestWrappedClass {
	public static void main(String[] args) {
		// 基本数据l类型转成包装类对象
		Integer a = new Integer(3);
		a.intValue();
		Integer b = Integer.valueOf(30);// 相当于new integer(30)
		// 把包装类对象转成基本数据类型
		int c = b.intValue();
		double d = b.doubleValue();

		// 把字符串转成包装类对象
		Integer e = new Integer("999999");
		Integer f = Integer.parseInt("9999");

		// 把包装类对象转成字符串
		String str = f.toString();

	}
}
