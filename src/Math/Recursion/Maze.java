package Java.Math.Recursion;

import java.util.Iterator;

public class Maze {
	public static void main(String[] args) {

		// �ȴ���һ����ά����,ģ���Թ�
		// ��ͼ
		int map[][] = new int[8][7];
		// ʹ��1��ʾǽ,����ȫ����Ϊ1
		for (int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}

		// ����ȫ����Ϊһ
		for (int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}

		// ���õ���,1��ʾ
		map[3][1] = 1;
		map[3][2] = 1;

		// �����ͼ
		System.out.println("��ͼ�����");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

		// ʹ�õݹ���ݸ�С����·
		setWay2(map, 1, 1);
		// ������µĵ�ͼ��С���߹�������ʶ���ĵĵݹ�

		System.out.println("С���߹�������ʶ���ĵĵݹ�");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 *
	 * @param map ��ʾ��ͼ
	 * @param i   ���Ǹ�λ�ÿ�ʼ��
	 * @param j
	 * @return ����ҵ�ͨ·�ͷ���true,���򷵻�false
	 */
	// 1.map��ʾ��ͼ
	// 2.i��j��ʾ�ӵ�ͼ���ĸ�λ�ÿ�ʼ����(1,1)
	// 3.���С���ܵ�map[6,5]λ�ã���˵��ͨ·�ҵ�
	// 4.Լ������map[i][j]Ϊ0��ʾ�õ�û���߹�,��Ϊ1ʱ��ʾǽ��2��ʾͨ·�����ߣ�3��ʾ�õ��Ѿ��߹��������߲�ͨ
	// 5.�����Թ�ʱ,��Ҫȷ��һ������(����) ��->��->��->��,����õ��߲�ͨ,�ٻ���
	// ʹ�õݹ��������С����·
	public static boolean setWay(int map[][], int i, int j) {

		if (map[6][5] == 2) {
			// ͨ·�Ѿ��ҵ�
			return true;
		} else {
			if (map[i][j] == 0) { // �����ǰ����㻹û���߹�
				// ���ղ�����->��->��->��,����õ��߲�ͨ,�ٻ���
				map[i][j] = 2; // �ٶ��õ�ʱ������ͨ
				if (setWay(map, i + 1, j)) {// ������
					return true;
				} else if (setWay(map, i, j + 1)) {// ������
					return true;
				} else if (setWay(map, i - 1, j)) {// ������
					return true;
				} else if (setWay(map, i, j - 1)) {// ������
					return true;
				} else {
					// ˵���õ��߲�ͨ������·
					map[i][j] = 3;
					return false;
				}
			} else {// ���map[i][j]!=0,������1,2,3
				return false;
			}
		}
	}

	// �޸���·�Ĳ���,�ĳ���->��->��->��
	public static boolean setWay2(int map[][], int i, int j) {

		if (map[6][5] == 2) {
			// ͨ·�Ѿ��ҵ�
			return true;
		} else {
			if (map[i][j] == 0) { // �����ǰ����㻹û���߹�
				// ���ղ�����->��->��->��,����õ��߲�ͨ,�ٻ���
				map[i][j] = 2; // �ٶ��õ�ʱ������ͨ
				if (setWay2(map, i + -1, j)) {// ������
					return true;
				} else if (setWay2(map, i, j + 1)) {// ������
					return true;
				} else if (setWay2(map, i + 1, j)) {// ������
					return true;
				} else if (setWay2(map, i, j - 1)) {// ������
					return true;
				} else {
					// ˵���õ��߲�ͨ������·
					map[i][j] = 3;
					return false;
				}
			} else {// ���map[i][j]!=0,������1,2,3
				return false;
			}
		}
	}

}
