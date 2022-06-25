package Java.Math.DataStructures;

public class SparseArray {
	public static void main(String[] args) {
		// �ȴ���ԭʼ�Ķ�ά����11*11
		// 0����ʾû������,1��ʾ
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		// ���ԭʼ�Ķ�ά����
		for (int row[] : chessArr1) { // ��һ�������������һά��
			for (int data : row) { // ֱ�ӱ���date�Ƕ�ά�����һά
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}

		// ����ά����תϡ������
		// 1.�ȱ�����ά���� �õ���0���ݵĸ���
		// 2.������Ӧ��ϡ������
		int sum = 0;
		for (int i = 0; i < chessArr1.length; i++) {
			for (int j = 0; j < chessArr1[0].length; j++) {
				if (chessArr1[i][j] != 0) {
					sum++;
				}
			}
		}
		int sparseArr[][] = new int[sum + 1][3];
		// ��ϡ�����鸳ֵ
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;

		int count = 0; // count���ڼ�¼�ǵڼ�����0����
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

		System.out.println("\n\n�õ���ϡ������");
		for (int i = 0; i < sparseArr.length; i++) {
			for (int j = 0; j < sparseArr[0].length; j++) {
				System.out.printf("%d\t", sparseArr[i][j]);
			}
			System.out.println();
		}

		// ��ϡ������->�ָ���ԭʼ�Ķ�ά����
		// 1.�ȶ�ȡϡ������ĵ�һ��,���ݵ�һ�е����ݣ�����ԭʼ�Ķ�ά����
		int ChessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][0]];

		for (int i = 1; i < sparseArr.length; i++) {
			ChessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}

		System.out.println("\n\nϡ������ָ�ԭ����");
		for (int i = 0; i < ChessArr2.length; i++) {
			for (int j = 0; j < ChessArr2[0].length; j++) {
				System.out.printf("%d\t", ChessArr2[i][j]);
			}
			System.out.println();
		}

	}

}
