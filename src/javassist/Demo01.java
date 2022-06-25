package javassist;

import javassist.ClassPool;

//����ʹ��javassist����һ���µ���
//����ʱ�����ֽ������������ʵ��
//1.��̬�����µ���
//2.��̬�ı�ĳ����Ľṹ(��ӡ�ɾ�����޸�)
public class Demo01 {
	public static void main(String[] args) throws Exception {
		ClassPool pool = ClassPool.getDefault();//��ȡ���
		CtClass cc = pool.makeClass("Emp");// ����Ҫ��������

		// ��������
		CtField f1 = CtField.make("private int empno;", cc);
		CtField f2 = CtField.make("private String ename;", cc);
		cc.addField(f1);
		cc.addField(f2);

		// ��������
		CtMethod m1 = CtMethod.make("public int getEmpno(){return empno;}", cc);
		CtMethod m2 = CtMethod.make("public void setEmpno(int empno){this.empno=empno;}", cc);
		cc.addMethod(m1);
		cc.addMethod(m2);

		// ��ӹ�����
		CtConstructor ct = new CtConstructor(new CtClass[] { CtClass.intType, pool.get("java.lang.String") }, cc);
		ct.setBody("{this.empno=empno;this.ename=ename;}");
		cc.addConstructor(ct);
		
		cc.writeFile("F:/Multifunctionapplication/Advanced Files/Java Project/myjava");// �����湹��õ���д�뵽���·����
		System.out.println("������,�ɹ�!");

	}
}
