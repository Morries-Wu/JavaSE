package Polymorphic;

//���ԷǾ�̬�ڲ���
public class TestInnerClass {
	public static void main(String[] args) {
		// �����ڲ������
		Outer.Inner inner = new Outer().new Inner();
		inner.show();
	}
}

class Outer {// ��һ����ͨ��

	// �Ǿ�̬�ڲ������ֱ�ӷ����ⲿ��ĳ�Ա�����ⲿ�಻��ֱ�ӷ��ʷǾ�̬�ڲ����Ա
	private int age = 10;

	public void testOuter() {
		System.out.println("Outer.testOuter()"); 
	}

	// �Ǿ�̬�ڲ��಻���о�̬��������̬���Ժ;�̬��ʼ����
	// ��̬�ڲ��෽����Ӧ��̬�ڲ���
	class Inner {
		int age = 20;

		public void show() {
			int age = 30;
			System.out.println("�ⲿ��ĳ�Ա����age:" + Outer.this.age);
			System.out.println("�ڲ���ĳ�Ա����age:" + this.age);
			System.out.println("�ڲ���ľֲ���Ա����age:" + age);
		}
	}

}