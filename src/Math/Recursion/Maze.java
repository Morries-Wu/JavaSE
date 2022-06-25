package Java.Math.Recursion;

import java.util.Iterator;

public class Maze {
	public static void main(String[] args) {

		// 先创建一个二维数组,模拟迷宫
		// 地图
		int map[][] = new int[8][7];
		// 使用1表示墙,上下全部置为1
		for (int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}

		// 左右全部置为一
		for (int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}

		// 设置挡板,1表示
		map[3][1] = 1;
		map[3][2] = 1;

		// 输出地图
		System.out.println("地图的情况");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

		// 使用递归回溯给小球找路
		setWay2(map, 1, 1);
		// 再输出新的地图，小球走过，并标识过的的递归

		System.out.println("小球走过，并标识过的的递归");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 *
	 * @param map 表示地图
	 * @param i   从那个位置开始找
	 * @param j
	 * @return 如果找到通路就返回true,否则返回false
	 */
	// 1.map表示地图
	// 2.i，j表示从地图的哪个位置开始出发(1,1)
	// 3.如果小球能到map[6,5]位置，则说明通路找到
	// 4.约定：当map[i][j]为0表示该点没有走过,当为1时表示墙；2表示通路可以走；3表示该点已经走过，但是走不通
	// 5.在走迷宫时,需要确定一个策略(方法) 下->右->上->左,如果该点走不通,再回溯
	// 使用递归回溯来给小球找路
	public static boolean setWay(int map[][], int i, int j) {

		if (map[6][5] == 2) {
			// 通路已经找到
			return true;
		} else {
			if (map[i][j] == 0) { // 如果当前这个点还没有走过
				// 按照策略下->右->上->左,如果该点走不通,再回溯
				map[i][j] = 2; // 假定该点时可以走通
				if (setWay(map, i + 1, j)) {// 向下走
					return true;
				} else if (setWay(map, i, j + 1)) {// 向右走
					return true;
				} else if (setWay(map, i - 1, j)) {// 向上走
					return true;
				} else if (setWay(map, i, j - 1)) {// 向左走
					return true;
				} else {
					// 说明该点走不通，是死路
					map[i][j] = 3;
					return false;
				}
			} else {// 如果map[i][j]!=0,可能是1,2,3
				return false;
			}
		}
	}

	// 修改找路的策略,改成上->右->下->左
	public static boolean setWay2(int map[][], int i, int j) {

		if (map[6][5] == 2) {
			// 通路已经找到
			return true;
		} else {
			if (map[i][j] == 0) { // 如果当前这个点还没有走过
				// 按照策略上->右->下->左,如果该点走不通,再回溯
				map[i][j] = 2; // 假定该点时可以走通
				if (setWay2(map, i + -1, j)) {// 向上走
					return true;
				} else if (setWay2(map, i, j + 1)) {// 向右走
					return true;
				} else if (setWay2(map, i + 1, j)) {// 向下走
					return true;
				} else if (setWay2(map, i, j - 1)) {// 向左走
					return true;
				} else {
					// 说明该点走不通，是死路
					map[i][j] = 3;
					return false;
				}
			} else {// 如果map[i][j]!=0,可能是1,2,3
				return false;
			}
		}
	}

}
