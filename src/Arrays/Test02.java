package Arrays;

public class Test02 {
	public static void main(String[] args) {
		// ��̬��ʼ��
		int a[] = { 2, 3, 4, 5 };
		User B[] = { new User(1001, "���"), new User(1002, "����"), new User(1003, "����") };
		// Ĭ�ϳ�ʼ��
		int b[] = new int[3]; // Ĭ�ϸ������Ԫ�ؽ��и�ֵ����ֵ�Ĺ���ͳ�Ա����Ĭ�ϸ�ֵ����һ�¡�
		int a2[] = new int[2]; // Ĭ��ֵ��0��0
		boolean b2[] = new boolean[2]; // Ĭ��ֵ:false,false
		String s[] = new String[2]; // Ĭ��ֵ:null,null
		// ��̬��ʼ��
		int a1[] = new int[2]; // ��̬��ʼ�����飬�ȷ���ռ�
		a1[0] = 1;// ������Ԫ�ظ�ֵ;
		a1[1] = 2;// ������Ԫ�ظ�ֵ;

	}
}
