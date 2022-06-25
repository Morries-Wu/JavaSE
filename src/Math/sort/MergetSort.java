package Java.Math.sort;

import java.util.Arrays;

public class MergetSort {
	public static void main(String[] args) {
		int arr[] = {8,4,5,7,1,3,6,2};
		int temp[] = new int[arr.length];// �鲢������Ҫ����Ŀռ�
		mergetSort(arr, 0, arr.length - 1, temp);
		System.out.println("arr=" + Arrays.toString(arr));
	}

	// ��+�Ϸ���
	public static void mergetSort(int arr[], int left, int right, int temp[]) {
		if (left < right) {
			int mid = (left + right) / 2;// �м�����
			// ����ݹ���зֽ�
			mergetSort(arr, left, mid, temp);
			// ���ҵݹ���зֽ�
			mergetSort(arr, mid + 1, right, temp);		
			// �ϲ�
			merge(arr, left, right, mid, temp);
		}
	}

	/**
	 * 
	 * @param arr   �����ԭʼ����
	 * @param left  ����������еĳ�ʼ����
	 * @param mid   �м�����
	 * @param right �ұ�����
	 * @param temp  ����ת������
	 */
	public static void merge(int arr[], int left, int right, int mid, int temp[]) {
		int i = left;// ��ʼ��i,����������еĳ�ʼ����
		int j = mid + 1;// ��ʼ��j,�ұ��������еĳ�ʼ����
		int t = 0;// ָ��temp����ĵ�ǰ����

		// һ
		// �Ȱ���������(����)�����ݰ��չ�����䵽temp����
		// ֱ���������ߵ���������,��һ�ߴ������Ϊֹ
		while (i <= mid && j <= right) {// ����
			// �����ߵ��������еĵ�ǰԪ��,С�ڵ����ұ��������еĵ�ǰԪ��
			// ������ߵĵ�ǰԪ��,������temp����
			// Ȼ��t++,i++
			if (arr[i] <= arr[j]) {
				temp[t] = arr[i];
				t++;
				i++;
			} else {
				// ��֮,���ұ��������еĵ�ǰԪ��,��䵽temp����
				temp[t] = arr[j];
				t++;
				j++;
			}
		}

		// ��
		// ����ʣ�����ݵ�һ�ߵ���������ȫ����䵽temp
		while (i <= mid) {
			temp[t] = arr[i];
			t++;
			i++;
		}

		while (j <= right) {
			temp[t] = arr[j];
			t++;
			j++;
		}

		// ��
		// ��temp�����Ԫ�ؿ�����arr
		// ע��,������ÿ�ζ���������
		t = 0;
		int tempLeft = left;
		while (tempLeft <= right) { // ��һ�κϲ� tempLeft=0,right=1||tempLeft=2 right=3 ||tempLeft=0,right=3
			arr[tempLeft] = temp[t];
			t++;
			tempLeft++;
		}
	}
}
