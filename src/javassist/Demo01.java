package javassist;

import javassist.ClassPool;

//测试使用javassist生成一个新的类
//运行时操作字节码可以让我们实现
//1.动态生成新的类
//2.动态改变某个类的结构(添加、删除、修改)
public class Demo01 {
	public static void main(String[] args) throws Exception {
		ClassPool pool = ClassPool.getDefault();//获取类池
		CtClass cc = pool.makeClass("Emp");// 代表要创建的类

		// 创建属性
		CtField f1 = CtField.make("private int empno;", cc);
		CtField f2 = CtField.make("private String ename;", cc);
		cc.addField(f1);
		cc.addField(f2);

		// 创建方法
		CtMethod m1 = CtMethod.make("public int getEmpno(){return empno;}", cc);
		CtMethod m2 = CtMethod.make("public void setEmpno(int empno){this.empno=empno;}", cc);
		cc.addMethod(m1);
		cc.addMethod(m2);

		// 添加构造器
		CtConstructor ct = new CtConstructor(new CtClass[] { CtClass.intType, pool.get("java.lang.String") }, cc);
		ct.setBody("{this.empno=empno;this.ename=ename;}");
		cc.addConstructor(ct);
		
		cc.writeFile("F:/Multifunctionapplication/Advanced Files/Java Project/myjava");// 将上面构造好的类写入到这个路径中
		System.out.println("生成类,成功!");

	}
}
