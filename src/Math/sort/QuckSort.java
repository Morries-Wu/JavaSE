package Java.Math.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuckSort {
	public static void main(String[] args) {
		int arr[] = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		System.out.println("����ǰ");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰ��ʱ����=" + date1Str);

		quickSort(arr, 0, arr.length - 1);

		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("����ǰ��ʱ����=" + date2Str);
		// System.out.println("arr=" + Arrays.toString(arr));
	}

	public static void quickSort(int arr[], int left, int right) {

		int l = left;// ���±�
		int r = right;// ���±�
		// pivot����ֵ
		int pivot = arr[(left + right) / 2];
		int temp = 0;// ��ʱ����,��Ϊ����ʱʹ��
		// whileѭ����Ŀ�����ñ�pivot ֵС�ŵ����
		// ��pivot ֵ��ŵ��ұ�
		while (l < r) {
			// ��pivot�����һֱ��,�ҵ����ڵ���pivotֵ,���˳�
			while (arr[l] < pivot) {
				l++;
			}
			// ��pivot���ұ�һֱ��,�ҵ�С�ڵ���pivotֵ,���˳�
			while (arr[r] > pivot) {
				r--;
			}

			// ���l>=r˵��pivot ���������ߵ�ֵ
			// �Ѿ��������ȫ������С�ڵ���pivotֵ���ұ�ȫ���Ǵ��ڵ���pivotֵ
			if (l == r) {
				break;
			}

			// ����
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;

			// ����������,����arr[l]==pivotֵ�����r--,ǰ��
			if (arr[l] == pivot) {
				r--;
			}

			// ����������,����arr[r]==pivotֵ�����l++,����
			if (arr[r] == pivot) {
				l++;
			}

		}
		System.out.println(Arrays.toString(arr));
		// �ӱ��������֮���ټ����������ҵݹ����� ���l==r,����l++,r--,����Ϊ����ջ���
		if (l == r) {
			l++;
			r--;
		}
		// ����ݹ�
		if (left < r) {
			quickSort(arr, left, r);
		}
		// ���ҵݹ�
		if (right > l) {
			quickSort(arr, l, right);
		}
	}

}
