package Reflection.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
元注解的作用就是对注解进一步的解释
retemtion作用:表示需要在什么级别保存该注释信息,用于描述注释的生命周期
*/
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation_Test01 {

	// 注解的参数:参数类型+参数名();
	String name() default "奥里给";	//定义name属性,默认值是  奥里给

	int age() default 0;

	int id() default -1;//如果默认值为-1代表不存在,indexof,如果找不到就返回-1

	String[] schools() default { "清华大学", "北京大学" };
}
