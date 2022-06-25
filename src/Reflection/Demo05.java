package Reflection;

import Reflection.Annotation.Table;
import Reflection.Annotation.myField;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;



public class Demo05 {

	public static void main(String[] args) throws Exception {
		try {
			Class clazz = Class.forName("Reflection.Annotation.Student");
			// ������������Чע��
			Annotation annotations[] = clazz.getAnnotations();
			for (Annotation temp : annotations) {
				System.out.println(temp);
			}

			// ������ָ��ע��
			Table table = (Table) clazz.getAnnotation(Table.class);
			System.out.println(table.value());

			// ���������Ե�ע��
			Field field = clazz.getDeclaredField("studentName");
			myField my = field.getAnnotation(myField.class);
			System.out.println(my.columnName() + "  " + my.type() + "  " + my.length());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
