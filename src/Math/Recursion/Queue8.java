package Java.Math.Recursion;

public class Queue8 {

	// ����һ��max��ʾ���ж��ٸ��ʺ�
	int max = 8;
	int array[] = new int[max];
	int count = 0;
	int jugdeCount = 0;

	// ��������array,����ʺ����λ�ý��������array={0,4,7,5,2,6,1,3}
	public static void main(String[] args) {
		Queue8 queue8 = new Queue8();
		queue8.check(0);
		System.out.println(queue8.count);
		System.out.println(queue8.jugdeCount);
	}

	// ��дһ������,���õ�n���ʺ�
	// �ر�ע�⣺check ��ÿһ�εݹ�ʱ�����뵽check�ж��� for (int i = 0; i < max; i++)
	private void check(int n) {
		if (n == max) { // n=8,��ʵ8���ʺ��Ѿ��ź���
			print();
			count++;
			return;
		}

		// ���η���ʺ󣬲��ж��Ƿ��ͻ
		for (int i = 0; i < max; i++) {
			jugdeCount++;
			// �Ȱѵ�ǰ����ʺ� n���ŵ����еĵ�1��
			array[n] = i;
			// �жϵ����õ�n���ʺ� ��i��ʱ���Ƿ��ͻ
			if (judge(n) == true) {// ����ͻ,���ŷ�n+1���ʺ�,����ʼ�ݹ�
				check(n + 1);
			}
			// �����ͻ,�ͼ���ִ��array[n] = i��������n���ʺ󣬷����ڱ��еĺ��Ƶ�һ��λ��
		}
	}

	// �鿴�����Ƿ��õ�n���ʺ󣬾�ȥ���ûʺ��Ƿ��ǰ���Ѿ��ݷõĻʺ��ͻ
	/**
	 * 
	 * @param n ��ʾ��n���ʺ�
	 * @return
	 */
	private boolean judge(int n) {
		for (int i = 0; i < n; i++) {
			// 1.array[i] == array[n] ��ʾ�ж� ��n���ʺ��Ƿ��ǰ���n-1���ʺ���ͬһ��
			// 2.Math.abs(n - i) == Math.abs(array[n] - array[i]) ��ʾ�жϵ�n���ʺ��Ƿ�͵�i�ʺ��Ƿ���ͬһб��
			if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}

	// дһ������,���Խ��ʺ�ڷŵ�λ�����
	private void print() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();

		int temp[][] = new int[max][max];
		for (int i = 0; i < temp.length; i++) {
			temp[i][array[i]] = 1;
		}

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

}
