package Arrays;

public class Test01 {
	public static void main(String[] args) {
		int arr01[]; // ��������
		arr01 = new int[10]; // ����ռ�
		String arr02[];
		User arr03[];

		arr03 = new User[3];
		arr03[0] = new User(1001, "���");
		arr03[1] = new User(1002, "�����");
		arr03[2] = new User(1003, "������");

		for (int i = 0; i < arr03.length; i++) {
			System.out.println(arr03[i].getName());
		}

		for (int i = 0; i < arr01.length; i++) {
			arr01[i] = i;
		}
		
		System.out.println("---------------------	");
		// foreachѭ�������ڶ�ȡ����Ԫ�ص�ֵ�������޸�Ԫ�ص�ֵ
		for (int m : arr01)// ѭ���������飬��ÿ��Ԫ��ȡ�����ŵ�m��������Ȼ����д�ӡ
		{
			System.out.println(m);
		}

	}
}
