package Java.Math.sort;

import java.text.SimpleDateFormat;
import java.util.*;
//�и���������²�Ҫ�û�������
public class RadixSort {
	public static void main(String[] args) {
		int arr[] = new int[8000000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 80000);
		}
		System.out.println("����ǰ");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰ��ʱ����=" + date1Str);
		
		radixSort(arr);
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("������ʱ����=" + date2Str);
		// System.out.println("arr=" + Arrays.toString(arr));
	}

	// �������򷽷�
	public static void radixSort(int arr[]) {

		// ��1��(���ÿ��Ԫ�صĸ�λ������������)
		// ����һ����ά����,��ʾ10��Ͱ,ÿ��Ͱ����һ��һλ����

		// 1.��ά�������10��һά����
		// 2.Ϊ�˷�ֹ�ڷ�������ʱ��,�������,��ÿ��һά����(Ͱ),��С����Ϊarr.length
		// 3.����������ʹ�ÿռ任ʱ��ľ����㷨
		int bucket[][] = new int[10][arr.length];

		// Ϊ�˼�¼ÿ��Ͱ��,ʵ�ʴ���˶��ٸ�����,���Ƕ���һ��һά��������¼����Ͱ��ÿ�η�������ݸ���
		// bucketElementCounts[0],��¼�ľ��� bucket[0]Ͱ�ķ������ݸ���
		// ���γ�ʼ��Ϊ0
		int bucketElementCounts[] = new int[10];

		// �����Ƶ�����,���Եõ����յĻ����������
		// 1.�õ�����������λ��
		int max = arr[0];// �����һ�������������
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		// �õ��������λ��
		int maxLength = (max + "").length();
		for (int i = 0, n = 1; i < maxLength; i++, n = n * 10) {
			// ���ÿ��Ԫ�صĶ�Ӧλ����������,��һ���Ǹ�λ,�ڶ�����ʮλ�������ǰ�λ.........
			for (int j = 0; j < arr.length; j++) {
				// ȡ��ÿ��Ԫ�صĶ�Ӧλ����ֵ
				int digtOfElement = arr[j] / n % 10;
				// ���뵽��Ӧ��Ͱ��
				// ÿ��bucketElementCounts[digtOfElement]��ʼ��ʱ����0
				bucket[digtOfElement][bucketElementCounts[digtOfElement]] = arr[j];
				// �����һ��bucketElementCounts[digtOfElement]��������֮��,����digtOfElementͰ�м�¼�ж��ٸ�����
				bucketElementCounts[digtOfElement]++;
			}
			// �������Ͱ��˳��(һά������±�����ȡ������,����ԭ������)
			int index = 0;
			// ����ÿһ��Ͱ,����Ͱ��������,���뵽ԭ����
			for (int k = 0; k < bucketElementCounts.length; k++) {
				// ���Ͱ��,������,���ǲŷ��뵽ԭ����
				if (bucketElementCounts[k] != 0) {
					// ѭ����Ͱ����K��Ͱ(����K��һά����),����
					for (int l = 0; l < bucketElementCounts[k]; l++) {
						// ȥ��Ԫ�ط��뵽arr
						arr[index++] = bucket[k][l];
					}
				}
				// ��1�ִ����,��Ҫ��ÿ��bucketElementCounts[k]=0
				bucketElementCounts[k] = 0;
			}
//			System.out.println("��" + i + 1 + "��,��λ��������arr=" + Arrays.toString(arr));
		}

//		// ��1��(���ÿ��Ԫ�صĸ�λ������������)
//		for (int j = 0; j < arr.length; j++) {
//			// ȡ��ÿ��Ԫ�صĸ�λ
//			int digtOfElement = arr[j] / 1 % 10;
//			// ���뵽��Ӧ��Ͱ��
//			// ÿ��bucketElementCounts[digtOfElement]��ʼ��ʱ����0
//			bucket[digtOfElement][bucketElementCounts[digtOfElement]] = arr[j];
//			// �����һ��bucketElementCounts[digtOfElement]��������֮��,����digtOfElementͰ�м�¼�ж��ٸ�����
//			bucketElementCounts[digtOfElement]++;
//		}
//		// �������Ͱ��˳��(һά������±�����ȡ������,����ԭ������)
//		int index = 0;
//		// ����ÿһ��Ͱ,����Ͱ��������,���뵽ԭ����
//		for (int k = 0; k < bucketElementCounts.length; k++) {
//			// ���Ͱ��,������,���ǲŷ��뵽ԭ����
//			if (bucketElementCounts[k] != 0) {
//				// ѭ����Ͱ����K��Ͱ(����K��һά����),����
//				for (int i = 0; i < bucketElementCounts[k]; i++) {
//					// ȥ��Ԫ�ط��뵽arr
//					arr[index++] = bucket[k][i];
//				}
//			}
//			// ��1�ִ����,��Ҫ��ÿ��bucketElementCounts[k]=0
//			bucketElementCounts[k] = 0;
//		}
//		System.out.println("��1��,��λ��������arr=" + Arrays.toString(arr));
//
//		// |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
//
//		// ��2��(���ÿ��Ԫ�ص�ʮλ������������)
//		for (int j = 0; j < arr.length; j++) {
//			// ȡ��ÿ��Ԫ�ص�ʮλ
//			int digtOfElement = arr[j] / 10 % 10;
//			// ���뵽��Ӧ��Ͱ��
//			// ÿ��bucketElementCounts[digtOfElement]��ʼ��ʱ����0
//			bucket[digtOfElement][bucketElementCounts[digtOfElement]] = arr[j];
//			// �����һ��bucketElementCounts[digtOfElement]��������֮��,����digtOfElementͰ�м�¼�ж��ٸ�����
//			bucketElementCounts[digtOfElement]++;
//		}
//		// �������Ͱ��˳��(һά������±�����ȡ������,����ԭ������)
//		index = 0;
//		// ����ÿһ��Ͱ,����Ͱ��������,���뵽ԭ����
//		for (int k = 0; k < bucketElementCounts.length; k++) {
//			// ���Ͱ��,������,���ǲŷ��뵽ԭ����
//			if (bucketElementCounts[k] != 0) {
//				// ѭ����Ͱ����K��Ͱ(����K��һά����),����
//				for (int i = 0; i < bucketElementCounts[k]; i++) {
//					// ȥ��Ԫ�ط��뵽arr
//					arr[index++] = bucket[k][i];
//				}
//			}
//			// ��2�ִ����,��Ҫ��ÿ��bucketElementCounts[k]=0
//			bucketElementCounts[k] = 0;
//		}
//		System.out.println("��2��,ʮλ��������arr=" + Arrays.toString(arr));
//
//		// |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
//
//		// ��3��(���ÿ��Ԫ�صİ�λ������������)
//		for (int j = 0; j < arr.length; j++) {
//			// ȡ��ÿ��Ԫ�صİ�λ
//			int digtOfElement = arr[j] / 100 % 10;
//			// ���뵽��Ӧ��Ͱ��
//			// ÿ��bucketElementCounts[digtOfElement]��ʼ��ʱ����0
//			bucket[digtOfElement][bucketElementCounts[digtOfElement]] = arr[j];
//			// �����һ��bucketElementCounts[digtOfElement]��������֮��,����digtOfElementͰ�м�¼�ж��ٸ�����
//			bucketElementCounts[digtOfElement]++;
//		}
//		// �������Ͱ��˳��(һά������±�����ȡ������,����ԭ������)
//		index = 0;
//		// ����ÿһ��Ͱ,����Ͱ��������,���뵽ԭ����
//		for (int k = 0; k < bucketElementCounts.length; k++) {
//			// ���Ͱ��,������,���ǲŷ��뵽ԭ����
//			if (bucketElementCounts[k] != 0) {
//				// ѭ����Ͱ����K��Ͱ(����K��һά����),����
//				for (int i = 0; i < bucketElementCounts[k]; i++) {
//					// ȥ��Ԫ�ط��뵽arr
//					arr[index++] = bucket[k][i];
//				}
//			}
//			// ��2�ִ����,��Ҫ��ÿ��bucketElementCounts[k]=0
//			bucketElementCounts[k] = 0;
//		}
//		System.out.println("��3��,��λ��������arr=" + Arrays.toString(arr));

	}
}
