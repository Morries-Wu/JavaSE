package Reflection;

import Reflection.Annotation.Table;
import Reflection.Annotation.myField;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;



public class Demo05 {

	public static void main(String[] args) throws Exception {
		try {
			Class clazz = Class.forName("Reflection.Annotation.Student");
			// 获得类的所有有效注解
			Annotation annotations[] = clazz.getAnnotations();
			for (Annotation temp : annotations) {
				System.out.println(temp);
			}

			// 获得类的指定注解
			Table table = (Table) clazz.getAnnotation(Table.class);
			System.out.println(table.value());

			// 获得类的属性的注解
			Field field = clazz.getDeclaredField("studentName");
			myField my = field.getAnnotation(myField.class);
			System.out.println(my.columnName() + "  " + my.type() + "  " + my.length());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
