package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//通过反射API动态的操作:构造器、方法、属性
public class Demo03 {
	public static void main(String[] args) {
		// 动态操作器
		String path = "Reflection.User";
		try {
			Class clazz = Class.forName(path);

			// 通过动态调用构造方法,构造对象
			User u = (User) clazz.newInstance();// 其实是调用了User的无参构造方法
			System.out.println(u);

			// 通过反射API调用构造方法,构造对象
			Constructor<User> c = clazz.getDeclaredConstructor(int.class, int.class, String.class);
			User u2 = c.newInstance(1001, 18, "狗子");
			System.out.println(u2.getAge() + u2.getName() + u2.getId());

			// 通过反射API调用普通方法
			User u3 = (User) clazz.newInstance();
			Method method = clazz.getDeclaredMethod("setName", String.class);
			method.invoke(u3, "狗哥");
			System.out.println(u3.getName());

			// 通过反射API操作属性
			User u4 = (User) clazz.newInstance();
			Field field = clazz.getDeclaredField("name");
			field.setAccessible(true); // 这个属性不需要做安全检查了,可以直接访问
			field.set(u4, "李连杰");    //field.set(实例对象, 属性值);
			System.out.println(u4.getName());
			System.out.println(field.get(u4));


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
