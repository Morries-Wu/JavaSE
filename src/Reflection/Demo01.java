package Reflection;

public class Demo01 {
	public static void main(String[] args) {
		String path = "Reflection.User";
		try {
			Class clazz = Class.forName(path);
			/**
			 * �����Ǳ�ʾ���װ����,һ���౻���غ�,jvm�ᴴ��һ����Ӧ�����Class����,��������ṹ��Ϣ��ŵ���Ӧ��Class������
			 * ���Class�������һ�澵��һ��,ͨ�����澵���ҿ��Կ������Ӧ���ȫ����Ϣ
 			 */

			System.out.println(clazz.hashCode());

			// һ����ֻ��Ӧһ��Class����
			Class clazz2 = Class.forName(path);
			System.out.println(clazz2.hashCode());

			Class strClazz = String.class;
			Class strClazz2 = path.getClass();
			System.out.println(strClazz == strClazz2);

			Class intClazz = int.class;
			int arr01[] = new int[10];
			int arr02[] = new int[20];
			int arr03[][] = new int[20][10];
			double arr04[] = new double[10];
			System.out.println(arr01.getClass().hashCode());
			System.out.println(arr02.getClass().hashCode());
			System.out.println(arr03.getClass().hashCode());
			System.out.println(arr04.getClass().hashCode());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}