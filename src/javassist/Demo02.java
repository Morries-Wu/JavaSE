package javassist;

import java.lang.reflect.Method;
import java.util.Arrays;

//����javassist��API
public class Demo02 {

	// ������Ļ����÷�
	public static void test01() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("javassist.Emp");

		byte bytes[] = cc.toBytecode();
		System.out.println(Arrays.toString(bytes));

		System.out.println(cc.getName());// ��ȡ����
		System.out.println(cc.getSimpleName());// ��ȡ��Ҫ����
		System.out.println(cc.getSuperclass());// ��ȡ����
		System.out.println(cc.getInterfaces());// ��ȡ�ӿ�

	}

	public static void test02() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("javassist.Emp");

		// CtMethod m1 = CtMethod.make("public int add(int a,int b){return a+b;}", cc);
		CtMethod m2 = new CtMethod(CtClass.intType, "add", new CtClass[] { CtClass.intType, CtClass.intType }, cc);
		m2.setModifiers(Modifier.PUBLIC);
		m2.setBody("{System.out.println(\"www.sxt.cn\");return $1+$2;}");

		// ͨ��������������ɵķ���
		Class clazz = cc.toClass();
		Object obj = clazz.newInstance();// ͨ������Emp�޲ι�����,�����µ�Emp����
		Method method = clazz.getDeclaredMethod("add", int.class, int.class);
		Object result = method.invoke(obj, 200, 300);
		System.out.println(result);
	}

	// �޸����еķ�������Ϣ,�޸ķ����������
	public static void test03() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("javassist.Emp");
		CtMethod cm = cc.getDeclaredMethod("sayHello", new CtClass[] { CtClass.intType });
		// cm.insertBefore("System.out.println($1);System.out.println(\"start!!!\");");
		cm.insertAt(25, "int b=3;System.out.println(\"b=\"+b);");
		// cm.insertAfter("System.out.println($1);System.out.println(\"start!!!\");");
		// ͨ��������������ɵķ���
		Class clazz = cc.toClass();
		Object obj = clazz.newInstance();// ͨ������Emp�޲ι�����,�����µ�Emp����
		Method method = clazz.getDeclaredMethod("sayHello", int.class);
		Object result = method.invoke(obj, 300);
	}

	// ���ԵĲ���
	public static void test04() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("javassist.Emp");

		// CtField f1 = CtField.make("private int empno ", cc);
		CtField f1 = new CtField(CtClass.intType, "salary", cc);
		f1.setModifiers(Modifier.PRIVATE);
		cc.addField(f1, "10");
		// cc.getDeclaredField("ename");//��ȡָ��������

		cc.addMethod(CtNewMethod.getter("salary", f1));
		cc.addMethod(CtNewMethod.getter("salary", f1));
	}

	// ���췽���Ĳ���
	public static void test05() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("javassist.Emp");

		CtConstructor cs[] = cc.getConstructors();
		for (CtConstructor c : cs) {
			System.out.println(c.getLongName());
		}
	}

	public static void test06() throws Exception {
		CtClass cc = ClassPool.getDefault().get("javassist.Emp");
		Object all[] = cc.getAnnotations();
		Author a = (Author) all[0];
		String name = a.name();
		int year = a.year();
		System.out.println("name:" + name + "year:" + year);
	}

	public static void main(String[] args) throws Exception {
		test06();
	}
}
