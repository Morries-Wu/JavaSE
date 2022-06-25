package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//应用反射的API,获取类的信息(类的名字、属性、方法、构造器等)
public class Demo02 {
	public static void main(String[] args) {
		String path = "Reflection.User";
		try {
			Class clazz = Class.forName(path);

			// 获取类的名字
			System.out.println(clazz.getName());// 获得包名+类名
			System.out.println(clazz.getSimpleName());// 获得类名

			// 获取属性信息
			// Field fields[] = clazz.getFields();// 只能获得public的field
			Field fields[] = clazz.getDeclaredFields();// 获得所有的field
			Field f = clazz.getDeclaredField("name");
			System.out.println(fields.length);
			System.out.println(f.getName());

			for (Field temp : fields) {
				System.out.println("属性" + temp);
			}
			System.out.println();

			// 获取方法信息
			Method method[] = clazz.getDeclaredMethods();
			Method m = clazz.getDeclaredMethod("getName", null);
			Method m2 = clazz.getDeclaredMethod("setName", String.class);// 如果方法有参,则必须传递参数类型对应的class对象
			for (Method temp : method) {
				System.out.println("方法" + temp);
			}
			System.out.println();

			// 获得构造器信息
			Constructor constructors[] = clazz.getDeclaredConstructors();
			Constructor constructor = clazz.getDeclaredConstructor(int.class, int.class, String.class);
			System.out.println("获得构造器:" + constructor);
			for (Constructor temp : constructors) {
				System.out.println("构造器" + temp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
