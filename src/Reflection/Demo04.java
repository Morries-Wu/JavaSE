package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//���һ��������ҪƵ���ĵ��÷��������÷���Ϊ�ɷ���״̬
public class Demo04 {

	public static void test01() {
		User u = new User();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			u.getName();
		}

		long endtime = System.currentTimeMillis();
		System.out.println("��ͨ��������,ִ��һ�����,��ʱ:" + (endtime - startTime) + "ms");
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
		System.out.println("���䶯̬����,ִ��һ�����,��ʱ:" + (endtime - startTime) + "ms");
	}

	public static void test03() throws Exception {
		User u = new User();
		Class clazz = u.getClass();
		Method m = clazz.getDeclaredMethod("getName", null);
		m.setAccessible(true); // ����Ҫִ�а�ȫ���
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			m.invoke(u, null);
		}

		long endtime = System.currentTimeMillis();
		System.out.println("���䶯̬����,ִ��һ�����,��ʱ:" + (endtime - startTime) + "ms");
	}

	public static void main(String[] args) throws Exception {
		test01();
		test02();
		test03();
	}

}
