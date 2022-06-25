package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//Ӧ�÷����API,��ȡ�����Ϣ(������֡����ԡ���������������)
public class Demo02 {
	public static void main(String[] args) {
		String path = "Reflection.User";
		try {
			Class clazz = Class.forName(path);

			// ��ȡ�������
			System.out.println(clazz.getName());// ��ð���+����
			System.out.println(clazz.getSimpleName());// �������

			// ��ȡ������Ϣ
			// Field fields[] = clazz.getFields();// ֻ�ܻ��public��field
			Field fields[] = clazz.getDeclaredFields();// ������е�field
			Field f = clazz.getDeclaredField("name");
			System.out.println(fields.length);
			System.out.println(f.getName());

			for (Field temp : fields) {
				System.out.println("����" + temp);
			}
			System.out.println();

			// ��ȡ������Ϣ
			Method method[] = clazz.getDeclaredMethods();
			Method m = clazz.getDeclaredMethod("getName", null);
			Method m2 = clazz.getDeclaredMethod("setName", String.class);// ��������в�,����봫�ݲ������Ͷ�Ӧ��class����
			for (Method temp : method) {
				System.out.println("����" + temp);
			}
			System.out.println();

			// ��ù�������Ϣ
			Constructor constructors[] = clazz.getDeclaredConstructors();
			Constructor constructor = clazz.getDeclaredConstructor(int.class, int.class, String.class);
			System.out.println("��ù�����:" + constructor);
			for (Constructor temp : constructors) {
				System.out.println("������" + temp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
