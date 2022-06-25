package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//ͨ������API��̬�Ĳ���:������������������
public class Demo03 {
	public static void main(String[] args) {
		// ��̬������
		String path = "Reflection.User";
		try {
			Class clazz = Class.forName(path);

			// ͨ����̬���ù��췽��,�������
			User u = (User) clazz.newInstance();// ��ʵ�ǵ�����User���޲ι��췽��
			System.out.println(u);

			// ͨ������API���ù��췽��,�������
			Constructor<User> c = clazz.getDeclaredConstructor(int.class, int.class, String.class);
			User u2 = c.newInstance(1001, 18, "����");
			System.out.println(u2.getAge() + u2.getName() + u2.getId());

			// ͨ������API������ͨ����
			User u3 = (User) clazz.newInstance();
			Method method = clazz.getDeclaredMethod("setName", String.class);
			method.invoke(u3, "����");
			System.out.println(u3.getName());

			// ͨ������API��������
			User u4 = (User) clazz.newInstance();
			Field field = clazz.getDeclaredField("name");
			field.setAccessible(true); // ������Բ���Ҫ����ȫ�����,����ֱ�ӷ���
			field.set(u4, "������");    //field.set(ʵ������, ����ֵ);
			System.out.println(u4.getName());
			System.out.println(field.get(u4));


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
