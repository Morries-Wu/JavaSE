package BOX;


import javax.sound.midi.Soundbank;

/*测试自动装箱,自动拆箱*/
public class TestAutoBox {
	public static void main(String[] args) {
		Integer a = 234; // 自动装箱.Integer a =Integer.valueOf(234);

		int b = a; // 自动拆箱.编译器会修改成：int b=a.intValue();

		// Integer c = null;
		// int d = c; // 自动拆箱:调用了:C.intValue()

		// 缓存[-128,127]之间的数字,实际就是系统初始的时候,创建了[-128,127]之间一个缓存数组
		Integer in3 = 1234;
		Integer in4 = 1234;
		System.out.println(in3 == in4);// fales是因为1234不在缓存范围内，所以in3和in4在内层生成对象虽然数值一样但是对象的引用地址不一样
		System.out.println(in3.equals(in4));
		System.out.println("##############");
		Integer in5 = 123;
		Integer in6 = 123;
		System.out.println(in5 == in6);// true是因为123在缓存范围内
		System.out.println(in5.equals(in6));

	}
}
