package Reflection.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
Ԫע������þ��Ƕ�ע���һ���Ľ���
retemtion����:��ʾ��Ҫ��ʲô���𱣴��ע����Ϣ,��������ע�͵���������
*/
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation_Test01 {

	// ע��Ĳ���:��������+������();
	String name() default "�����";	//����name����,Ĭ��ֵ��  �����

	int age() default 0;

	int id() default -1;//���Ĭ��ֵΪ-1��������,indexof,����Ҳ����ͷ���-1

	String[] schools() default { "�廪��ѧ", "������ѧ" };
}
