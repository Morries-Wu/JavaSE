
package Reflection.Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

//使用反射读取注解的信息,模拟处理注解信息的流程
public class Demo03 {
	public static void main(String[] args) {
		try {
			// 获得类的所有有效注解
			Class clazz = Class.forName("Reflection.Annotation.Student");
			Annotation annotations[] = clazz.getAnnotations();
			for (Annotation a : annotations) {
				System.out.println(a);
			}
			// 获得类的指定的注解
			Table st = (Table) clazz.getAnnotation(Table.class);
			System.out.println(st);

			// 获得类的属性的注解
			Field f = clazz.getDeclaredField("age");
			myField field = f.getAnnotation(myField.class);
			System.out.println(field.columnName() + "  " + field.type() + " " + field.length());
			//根据获得的表名、字段的信息,拼出DDL语句,然后,使用JDBC执行这个SQL,在数据库生成相关的表
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
