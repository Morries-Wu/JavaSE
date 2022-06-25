
package Reflection.Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

//ʹ�÷����ȡע�����Ϣ,ģ�⴦��ע����Ϣ������
public class Demo03 {
	public static void main(String[] args) {
		try {
			// ������������Чע��
			Class clazz = Class.forName("Reflection.Annotation.Student");
			Annotation annotations[] = clazz.getAnnotations();
			for (Annotation a : annotations) {
				System.out.println(a);
			}
			// ������ָ����ע��
			Table st = (Table) clazz.getAnnotation(Table.class);
			System.out.println(st);

			// ���������Ե�ע��
			Field f = clazz.getDeclaredField("age");
			myField field = f.getAnnotation(myField.class);
			System.out.println(field.columnName() + "  " + field.type() + " " + field.length());
			//���ݻ�õı������ֶε���Ϣ,ƴ��DDL���,Ȼ��,ʹ��JDBCִ�����SQL,�����ݿ�������صı�
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
