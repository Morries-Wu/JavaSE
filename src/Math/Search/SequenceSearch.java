package Java.Math.Search;

public class SequenceSearch {
	public static void main(String[] args) {
		int arr[] = { 1, 9, 11, -1, 34, 89 };
		int index = sequenceSearch(arr, 11);
		if (index == -1) {
			System.out.println("û���ҵ�");
		} else {
			System.out.println("�ҵ�,�±�Ϊ=" + index);
		}
	}

	/**
	 * ��������ʵ�ֵ����Բ������ҵ�һ������������ֵ,�ͷ���
	 * 
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int sequenceSearch(int arr[], int value) {
		// ���Բ�����һ�ȶ�,��������ֵͬ,�ͷ����±�
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}

}