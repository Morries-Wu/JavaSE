package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//如果一个程序需要频繁的调用反射则设置方法为可访问状态
public class Demo04 {

	public static void test01() {
		User u = new User();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			u.getName();
		}

		long endtime = System.currentTimeMillis();
		System.out.println("普通方法调用,执行一百万次,耗时:" + (endtime - startTime) + "ms");
	}

	public static void test02() throws Exception {
		User u = new User();
		Class clazz = u.getClass();
		Method m = clazz.getDeclaredMethod("getName", null);
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			m.invoke(u, null);
		}

		long endtime = System.currentTimeMillis();
		System.out.println("反射动态调用,执行一百万次,耗时:" + (endtime - startTime) + "ms");
	}

	public static void test03() throws Exception {
		User u = new User();
		Class clazz = u.getClass();
		Method m = clazz.getDeclaredMethod("getName", null);
		m.setAccessible(true); // 不需要执行安全检查
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			m.invoke(u, null);
		}

		long endtime = System.currentTimeMillis();
		System.out.println("反射动态调用,执行一百万次,耗时:" + (endtime - startTime) + "ms");
	}

	public static void main(String[] args) throws Exception {
		test01();
		test02();
		test03();
	}

}
