package Java.Math.sort;

import java.util.Arrays;

public class ShellShiftSort {
	public static void main(String[] args) {
		int arr[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		System.out.println(Arrays.toString(arr));
		int indexValue = 0;
		int insertIndex = 0;
		int count = 0;
		// ����group,���𲽵���С����
		// ��λϣ������
		for (int group = arr.length / 2; group >0; group = group / 2) {
			// �ӵ�group��Ԫ�ؿ�ʼ������������ڵ������ֱ�Ӳ�������
			for (int i = group; i < arr.length; i++) {
				insertIndex = i;
				indexValue = arr[insertIndex];
				while (insertIndex - group >= 0 && indexValue < arr[insertIndex - group]) {
					// �ƶ�
					arr[insertIndex] = arr[insertIndex - group];
					insertIndex = insertIndex - group;
				}
				// ���˳�ѭ����,�͸�temp�ҵ������λ��
				arr[insertIndex] = indexValue;
			}
			System.out.println("��" + count++ + "�ַ���������" + Arrays.toString(arr));
		}
	}

}
