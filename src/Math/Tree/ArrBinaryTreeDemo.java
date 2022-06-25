package Math.Tree;

public class ArrBinaryTreeDemo {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };

		// ����һ��ArrBianaryTree
		ArrBinaryTree arrtree = new ArrBinaryTree(arr);
		System.out.println("ǰ�����");
		arrtree.pre_out(1);
		System.out.println("____________");

		System.out.println("�������");
		arrtree.mid_out(2);
		System.out.println("____________");

		System.out.println("�������");
		arrtree.pos_out(2);
	}
}

//��дһ��ArrayBinaryTree,ʵ��˳��洢����������
class ArrBinaryTree {
	private int[] arr;// �洢����������

	public ArrBinaryTree(int[] arr) {
		super();
		this.arr = arr;
	}

	// ��дһ������,���˳��洢��������ǰ�����
	// index��ʾ�����±�
	public void pre_out(int index) {
		// �������Ϊ��,����arr.length=0
		if (arr == null || arr.length == 0) {
			System.out.println("����Ϊ��,���ܰ��ն�������ǰ�����");
		}
		// �����ǰԪ��
		System.out.println(arr[index]);
		// ����ݹ����
		if (index * 2 + 1 < arr.length) {
			pre_out(index * 2 + 1);
		}
		// ���ҵݹ����
		if (index * 2 + 2 < arr.length) {
			pre_out(index * 2 + 2);
		}

	}

	// ��дһ������,���˳��洢���������������
	// index��ʾ�����±�
	public void mid_out(int index) {

		// �������Ϊ��,����arr.length=0
		if (arr == null || arr.length == 0) {
			System.out.println("����Ϊ��,���ܰ��ն�������ǰ�����");
		}

		// ����ݹ����
		if (index * 2 + 1 < arr.length) {
			pre_out(index * 2 + 1);
		}
		// �����ǰԪ��
		System.out.println(arr[index]);
		// ���ҵݹ����
		if (index * 2 + 2 < arr.length) {
			pre_out(index * 2 + 2);
		}

	}

	// ��дһ������,���˳��洢�������ĺ������
	// index��ʾ�����±�
	public void pos_out(int index) {

		// �������Ϊ��,����arr.length=0
		if (arr == null || arr.length == 0) {
			System.out.println("����Ϊ��,���ܰ��ն�������ǰ�����");
		}

		// ����ݹ����
		if (index * 2 + 1 < arr.length) {
			pre_out(index * 2 + 1);
		}

		// ���ҵݹ����
		if (index * 2 + 2 < arr.length) {
			pre_out(index * 2 + 2);
		}

		// �����ǰԪ��
		System.out.println(arr[index]);

	}

}