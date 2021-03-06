package Reflection;

public class Demo01 {
	public static void main(String[] args) {
		String path = "Reflection.User";
		try {
			Class clazz = Class.forName(path);
			/**
			 * 对象是表示或封装数据,一个类被加载后,jvm会创建一个对应该类的Class对象,类的整个结构信息会放到对应的Class对象中
			 * 这个Class对象就像一面镜子一样,通过这面镜子我可以看到这对应类的全部信息
 			 */

			System.out.println(clazz.hashCode());

			// 一个类只对应一个Class对象
			Class clazz2 = Class.forName(path);
			System.out.println(clazz2.hashCode());

			Class strClazz = String.class;
			Class strClazz2 = path.getClass();
			System.out.println(strClazz == strClazz2);

			Class intClazz = int.class;
			int arr01[] = new int[10];
			int arr02[] = new int[20];
			int arr03[][] = new int[20][10];
			double arr04[] = new double[10];
			System.out.println(arr01.getClass().hashCode());
			System.out.println(arr02.getClass().hashCode());
			System.out.println(arr03.getClass().hashCode());
			System.out.println(arr04.getClass().hashCode());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
