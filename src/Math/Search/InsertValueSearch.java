package Java.Math.Search;

import java.util.Arrays;

//������������,�ؼ��ֲַ��ȽϾ��ȵĲ�����˵,���ò�ֵ����,�ٶȱȽϿ�
//�ؼ��ֲַ������ȵ������,�÷�����һ�����۰����Ҫ��
public class InsertValueSearch {
	public static void main(String[] args) {
		int arr[] = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		System.out.println(Arrays.toString(arr));

		System.out.println(inserValueSearch(arr, 0, arr.length - 1, 55));
	}

	// ��д��ֵ�����㷨
	public static int inserValueSearch(int arr[], int left, int right, int value) {
		System.out.println("------");
		// ע��:value<arr[0]��value>arr[arr.length-1]������Ҫ
		// �������ǵõ���mid����Խ��
		if (left > right || value > arr[arr.length - 1] || value < arr[0]) {
			return -1;
		}
		// ���mid
		int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
		int midvalue = arr[mid];
		if (value > midvalue) {// ˵��Ӧ�����ұߵݹ�
			inserValueSearch(arr, mid + 1, right, midvalue);
		} else if (value < midvalue) {
			inserValueSearch(arr, mid - 1, right, midvalue);
		} else {
			return mid;
		}
		return mid;
	}

}
