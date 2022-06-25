package Reflection.Annotation;

import java.lang.reflect.Method;

@MyAnnotation_Test01
public class Demo02 {

    //注解可以显示赋值,如果没有默认值,我们就必须给注解赋值
    @MyAnnotation_Test01(age = 19, name = "祥哥", id = 1001, schools = {"理工大学", "北京航空"})
    public void test() {
    }

    @MyAnnotation_Test02(value = "aaa")
    public void test2() {
    }


    public static void main(String[] args) throws NoSuchMethodException {
        //1、获得字节码
        Class<Demo02> clz = Demo02.class;

        //2、反射类的注解
        MyAnnotation_Test01 annotation = clz.getAnnotation(MyAnnotation_Test01.class);
        if (annotation != null) {
            System.out.println(annotation.name());
        }

        //2、反射方法的注解
        Method test = clz.getMethod("test");
        MyAnnotation_Test01 annotation_test01 = test.getAnnotation(MyAnnotation_Test01.class);
        if (annotation_test01 != null) {
            System.out.println(annotation_test01.name());
        }

    }


}
