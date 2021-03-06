package Java.Math.sort;

import java.text.SimpleDateFormat;
import java.util.*;
//有负数的情况下不要用基数排序
public class RadixSort {
	public static void main(String[] args) {
		int arr[] = new int[8000000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 80000);
		}
		System.out.println("排序前");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是=" + date1Str);
		
		radixSort(arr);
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序后的时间是=" + date2Str);
		// System.out.println("arr=" + Arrays.toString(arr));
	}

	// 基数排序方法
	public static void radixSort(int arr[]) {

		// 第1轮(针对每个元素的个位数进行排序处理)
		// 定义一个二维数组,表示10个桶,每个桶就是一个一位数组

		// 1.二维数组包含10个一维数组
		// 2.为了防止在放入数的时候,数据溢出,则每个一维数据(桶),大小定义为arr.length
		// 3.基数排序是使用空间换时间的经典算法
		int bucket[][] = new int[10][arr.length];

		// 为了记录每个桶中,实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
		// bucketElementCounts[0],记录的就是 bucket[0]桶的放入数据个数
		// 整形初始化为0
		int bucketElementCounts[] = new int[10];

		// 根据推导过程,可以得到最终的基数排序代码
		// 1.得到数组中最大的位数
		int max = arr[0];// 假设第一个数就是最大数
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		// 得到最大数的位数
		int maxLength = (max + "").length();
		for (int i = 0, n = 1; i < maxLength; i++, n = n * 10) {
			// 针对每个元素的对应位进行排序处理,第一次是个位,第二次是十位第三次是百位.........
			for (int j = 0; j < arr.length; j++) {
				// 取出每个元素的对应位数的值
				int digtOfElement = arr[j] / n % 10;
				// 放入到对应的桶中
				// 每个bucketElementCounts[digtOfElement]初始的时候都是0
				bucket[digtOfElement][bucketElementCounts[digtOfElement]] = arr[j];
				// 如果第一次bucketElementCounts[digtOfElement]放入数据之后,就在digtOfElement桶中记录有多少个数据
				bucketElementCounts[digtOfElement]++;
			}
			// 按照这个桶的顺序(一维数组的下标依次取出数据,放入原来数组)
			int index = 0;
			// 遍历每一个桶,并将桶中是数据,放入到原数组
			for (int k = 0; k < bucketElementCounts.length; k++) {
				// 如果桶中,有数据,我们才放入到原数组
				if (bucketElementCounts[k] != 0) {
					// 循环该桶即第K个桶(即第K个一维数组),放入
					for (int l = 0; l < bucketElementCounts[k]; l++) {
						// 去除元素放入到arr
						arr[index++] = bucket[k][l];
					}
				}
				// 第1轮处理后,需要将每个bucketElementCounts[k]=0
				bucketElementCounts[k] = 0;
			}
//			System.out.println("第" + i + 1 + "轮,个位的排序处理arr=" + Arrays.toString(arr));
		}

//		// 第1轮(针对每个元素的个位数进行排序处理)
//		for (int j = 0; j < arr.length; j++) {
//			// 取出每个元素的个位
//			int digtOfElement = arr[j] / 1 % 10;
//			// 放入到对应的桶中
//			// 每个bucketElementCounts[digtOfElement]初始的时候都是0
//			bucket[digtOfElement][bucketElementCounts[digtOfElement]] = arr[j];
//			// 如果第一次bucketElementCounts[digtOfElement]放入数据之后,就在digtOfElement桶中记录有多少个数据
//			bucketElementCounts[digtOfElement]++;
//		}
//		// 按照这个桶的顺序(一维数组的下标依次取出数据,放入原来数组)
//		int index = 0;
//		// 遍历每一个桶,并将桶中是数据,放入到原数组
//		for (int k = 0; k < bucketElementCounts.length; k++) {
//			// 如果桶中,有数据,我们才放入到原数组
//			if (bucketElementCounts[k] != 0) {
//				// 循环该桶即第K个桶(即第K个一维数组),放入
//				for (int i = 0; i < bucketElementCounts[k]; i++) {
//					// 去除元素放入到arr
//					arr[index++] = bucket[k][i];
//				}
//			}
//			// 第1轮处理后,需要将每个bucketElementCounts[k]=0
//			bucketElementCounts[k] = 0;
//		}
//		System.out.println("第1轮,个位的排序处理arr=" + Arrays.toString(arr));
//
//		// |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
//
//		// 第2轮(针对每个元素的十位数进行排序处理)
//		for (int j = 0; j < arr.length; j++) {
//			// 取出每个元素的十位
//			int digtOfElement = arr[j] / 10 % 10;
//			// 放入到对应的桶中
//			// 每个bucketElementCounts[digtOfElement]初始的时候都是0
//			bucket[digtOfElement][bucketElementCounts[digtOfElement]] = arr[j];
//			// 如果第一次bucketElementCounts[digtOfElement]放入数据之后,就在digtOfElement桶中记录有多少个数据
//			bucketElementCounts[digtOfElement]++;
//		}
//		// 按照这个桶的顺序(一维数组的下标依次取出数据,放入原来数组)
//		index = 0;
//		// 遍历每一个桶,并将桶中是数据,放入到原数组
//		for (int k = 0; k < bucketElementCounts.length; k++) {
//			// 如果桶中,有数据,我们才放入到原数组
//			if (bucketElementCounts[k] != 0) {
//				// 循环该桶即第K个桶(即第K个一维数组),放入
//				for (int i = 0; i < bucketElementCounts[k]; i++) {
//					// 去除元素放入到arr
//					arr[index++] = bucket[k][i];
//				}
//			}
//			// 第2轮处理后,需要将每个bucketElementCounts[k]=0
//			bucketElementCounts[k] = 0;
//		}
//		System.out.println("第2轮,十位的排序处理arr=" + Arrays.toString(arr));
//
//		// |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
//
//		// 第3轮(针对每个元素的百位数进行排序处理)
//		for (int j = 0; j < arr.length; j++) {
//			// 取出每个元素的百位
//			int digtOfElement = arr[j] / 100 % 10;
//			// 放入到对应的桶中
//			// 每个bucketElementCounts[digtOfElement]初始的时候都是0
//			bucket[digtOfElement][bucketElementCounts[digtOfElement]] = arr[j];
//			// 如果第一次bucketElementCounts[digtOfElement]放入数据之后,就在digtOfElement桶中记录有多少个数据
//			bucketElementCounts[digtOfElement]++;
//		}
//		// 按照这个桶的顺序(一维数组的下标依次取出数据,放入原来数组)
//		index = 0;
//		// 遍历每一个桶,并将桶中是数据,放入到原数组
//		for (int k = 0; k < bucketElementCounts.length; k++) {
//			// 如果桶中,有数据,我们才放入到原数组
//			if (bucketElementCounts[k] != 0) {
//				// 循环该桶即第K个桶(即第K个一维数组),放入
//				for (int i = 0; i < bucketElementCounts[k]; i++) {
//					// 去除元素放入到arr
//					arr[index++] = bucket[k][i];
//				}
//			}
//			// 第2轮处理后,需要将每个bucketElementCounts[k]=0
//			bucketElementCounts[k] = 0;
//		}
//		System.out.println("第3轮,百位的排序处理arr=" + Arrays.toString(arr));

	}
}
