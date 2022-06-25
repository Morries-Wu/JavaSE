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
		System.out.println("排序前");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是=" + date1Str);

		quickSort(arr, 0, arr.length - 1);

		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间是=" + date2Str);
		// System.out.println("arr=" + Arrays.toString(arr));
	}

	public static void quickSort(int arr[], int left, int right) {

		int l = left;// 左下标
		int r = right;// 右下标
		// pivot中轴值
		int pivot = arr[(left + right) / 2];
		int temp = 0;// 临时变量,作为交换时使用
		// while循环的目的是让比pivot 值小放到左边
		// 比pivot 值大放到右边
		while (l < r) {
			// 在pivot的左边一直找,找到大于等于pivot值,才退出
			while (arr[l] < pivot) {
				l++;
			}
			// 在pivot的右边一直找,找到小于等于pivot值,才退出
			while (arr[r] > pivot) {
				r--;
			}

			// 如果l>=r说明pivot 的左右两边的值
			// 已经按照左边全部都是小于等于pivot值，右边全部是大于等于pivot值
			if (l == r) {
				break;
			}

			// 交换
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;

			// 如果交换完后,发现arr[l]==pivot值相等让r--,前移
			if (arr[l] == pivot) {
				r--;
			}

			// 如果交换完后,发现arr[r]==pivot值相等让l++,后移
			if (arr[r] == pivot) {
				l++;
			}

		}
		System.out.println(Arrays.toString(arr));
		// 从本层遍历完之后再继续划分左右递归排序 如果l==r,必须l++,r--,否则为出现栈溢出
		if (l == r) {
			l++;
			r--;
		}
		// 向左递归
		if (left < r) {
			quickSort(arr, left, r);
		}
		// 向右递归
		if (right > l) {
			quickSort(arr, l, right);
		}
	}

}
