package Reflection.Annotation;

import java.lang.reflect.Method;

@MyAnnotation_Test01
public class Demo02 {

    //ע�������ʾ��ֵ,���û��Ĭ��ֵ,���Ǿͱ����ע�⸳ֵ
    @MyAnnotation_Test01(age = 19, name = "���", id = 1001, schools = {"����ѧ", "��������"})
    public void test() {
    }

    @MyAnnotation_Test02(value = "aaa")
    public void test2() {
    }


    public static void main(String[] args) throws NoSuchMethodException {
        //1������ֽ���
        Class<Demo02> clz = Demo02.class;

        //2���������ע��
        MyAnnotation_Test01 annotation = clz.getAnnotation(MyAnnotation_Test01.class);
        if (annotation != null) {
            System.out.println(annotation.name());
        }

        //2�����䷽����ע��
        Method test = clz.getMethod("test");
        MyAnnotation_Test01 annotation_test01 = test.getAnnotation(MyAnnotation_Test01.class);
        if (annotation_test01 != null) {
            System.out.println(annotation_test01.name());
        }

    }


}
