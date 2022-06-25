package Java.Math.DataStructures;

public class SparseArray {
	public static void main(String[] args) {
		// 先创建原始的二维数组11*11
		// 0：表示没有棋子,1表示
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		// 输出原始的二维数组
		for (int row[] : chessArr1) { // 第一个数组遍历的是一维的
			for (int data : row) { // 直接遍历date是二维里面的一维
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}

		// 将二维数组转稀疏数组
		// 1.先遍历二维数组 得到非0数据的个数
		// 2.创建对应的稀疏数组
		int sum = 0;
		for (int i = 0; i < chessArr1.length; i++) {
			for (int j = 0; j < chessArr1[0].length; j++) {
				if (chessArr1[i][j] != 0) {
					sum++;
				}
			}
		}
		int sparseArr[][] = new int[sum + 1][3];
		// 给稀疏数组赋值
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;

		int count = 0; // count用于记录是第几个非0数据
		for (int i = 0; i < chessArr1.length; i++) {
			for (int j = 0; j < chessArr1[0].length; j++) {
				if (chessArr1[i][j] != 0) {
					count++;
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = chessArr1[i][j];
				}
			}
		}

		System.out.println("\n\n得到的稀疏数组");
		for (int i = 0; i < sparseArr.length; i++) {
			for (int j = 0; j < sparseArr[0].length; j++) {
				System.out.printf("%d\t", sparseArr[i][j]);
			}
			System.out.println();
		}

		// 将稀疏数组->恢复成原始的二维数组
		// 1.先读取稀疏数组的第一行,根据第一行的数据，创建原始的二维数组
		int ChessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][0]];

		for (int i = 1; i < sparseArr.length; i++) {
			ChessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}

		System.out.println("\n\n稀疏数组恢复原数组");
		for (int i = 0; i < ChessArr2.length; i++) {
			for (int j = 0; j < ChessArr2[0].length; j++) {
				System.out.printf("%d\t", ChessArr2[i][j]);
			}
			System.out.println();
		}

	}

}
