package Java.Math.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//:ʹ�ö��ֲ��ҵ�ǰ���Ǹ������������
public class BinarySearch {
	public static void main(String[] args) {
		int arr[] = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(binarySearch(arr, 0, arr.length - 1, 55));
	}

	// ���ֲ����㷨
	public static int binarySearch(int arr[], int left, int right, int value) {
		System.out.println("------");
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		int midvalue = arr[mid];
		if (value > midvalue) { // ���ҵݹ�
			return binarySearch(arr, mid + 1, right, value);
		} else if (value < midvalue) {// ����ݹ�
			return binarySearch(arr, left, mid - 1, value);
		} else {
			return mid;
		}
	}

	// ���һ���κ�˼����
	// �κ�˼���⣺{1,8,10,89,100,100,123}��������������
	// �ж��ٸ���ͬ������ʱ,��ν����е���ֵ�����ҵ�,����������ߵ�100

	public static ArrayList<Integer> binarySearch2(int arr[], int left, int right, int value) {
		if (left > right) {
			return new ArrayList<Integer>(-1);
		}
		int mid = (left + right) / 2;
		int midvalue = arr[mid];
		if (value > midvalue) { // ���ҵݹ�
			return binarySearch2(arr, mid + 1, right, value);
		} else if (value < midvalue) {// ����ݹ�
			return binarySearch2(arr, left, mid - 1, value);
		} else {
			// ˼·����
			// 1.���ҵ�mid����ֵ,��Ҫ���Ϸ���
			// 2.��mid ����ֵ�����ɨ��,����������100��Ԫ�ص��±�,���뵽����ArrayList
			// 3.��mid ����ֵ���ұ�ɨ��,����������100��Ԫ�ص��±�,���뵽����ArrayList
			ArrayList<Integer> resIndexlist = new ArrayList<Integer>();
			int temp = mid - 1;
			while (true) {
				if (temp < 0 || arr[temp] != value) {
					break;
				}
				// ����,�Ͱ�temp���뵽resIndexlist
				resIndexlist.add(temp);
				temp--;// temp����
			}
			resIndexlist.add(mid);
			temp = mid + 1;
			while (true) {
				if (temp > arr.length - 1 || arr[temp] != value) {
					break;
				}
				// ����,�Ͱ�temp���뵽resIndexlist
				resIndexlist.add(temp);
				temp++;// temp����
			}
			return resIndexlist;
		}
	}
}
