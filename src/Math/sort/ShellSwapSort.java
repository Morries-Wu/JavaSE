package Java.Math.sort;

import java.util.Arrays;

public class ShellSwapSort {
	public static void main(String[] args) {
		int arr[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		int temp = 0;
		int count = 0;
		// ϣ�����򽻻���
		for (int group = arr.length / 2; group > 0; group = group / 2) {
			for (int i = group; i < arr.length; i++) {
				for (int j = i - group; j >= 0; j = j - group) {
					// �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ��,˵����Ҫ����
					if (arr[j] > arr[j + group]) {
						temp = arr[j];
						arr[j] = arr[j + group];
						arr[j + group] = temp;
					}
				}
			}
			System.out.println("��" + count++ + "�ַ���������" + Arrays.toString(arr));
		}

//		// ϣ������ĵ�1������
//		// ��Ϊ��1������,�ǽ�10�����ݷֳ�5��
//		for (int i = 5; i < arr.length; i++) {
//			// �������������е�Ԫ��(����M,ÿ�M��2��Ԫ��)������5
//			for (int j = i - 5; j >= 0; j = j - 5) {
//				// �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ��,˵����Ҫ����
//				if (arr[j] > arr[j + 5]) {
//					temp = arr[j];
//					arr[j] = arr[j + 5];
//					arr[j + 5] = temp;
//				}
//			}
//		}
//		System.out.println("��һ�ַ���������" + Arrays.toString(arr));
//
//		// ϣ������ĵ�2������
//		// ��Ϊ��2������,�ǽ�10�����ݷֳ�5/2=2��
//		for (int i = 2; i < arr.length; i++) {
//			// �������������е�Ԫ��(����M,ÿ�M��2��Ԫ��)������5
//			for (int j = i - 2; j >= 0; j = j - 2) {
//				// �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ��,˵����Ҫ����
//				if (arr[j] > arr[j + 2]) {
//					temp = arr[j];
//					arr[j] = arr[j + 2];
//					arr[j + 2] = temp;
//				}
//			}
//		}
//		System.out.println("�ڶ��ַ���������" + Arrays.toString(arr));
//
//		// ϣ������ĵ�3������
//		// ��Ϊ��3������,�ǽ�10�����ݷֳ�2/2=1��
//		for (int i = 1; i < arr.length; i++) {
//			// �������������е�Ԫ��(����M,ÿ�M��2��Ԫ��)������5
//			for (int j = i - 1; j >= 0; j = j - 1) {
//				// �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ��,˵����Ҫ����
//				if (arr[j] > arr[j + 1]) {
//					temp = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = temp;
//				}
//			}
//		}
//		System.out.println("�����ַ���������" + Arrays.toString(arr));

	}
}
