package String;

//测试StringBuilder、StringBuffer是可变字符序列，数组内容可随意修改
public class TestStringBuilder {
	public static void main(String[] args) {

		// StringBuilder线程不安全,效率高（一般用它）,StringBuffer线程安全,效率低
		StringBuilder s1 = new StringBuilder("abcdefg"); // StringBuilder和String不一样，但可以做各种截断处理因为内层char vaule[]可修改;

		System.out.println(Integer.toHexString(s1.hashCode()));

		System.out.println(s1);
		s1.setCharAt(0, '帅');
		System.out.println(Integer.toHexString(s1.hashCode()));
		System.out.println(s1);
	}
}
