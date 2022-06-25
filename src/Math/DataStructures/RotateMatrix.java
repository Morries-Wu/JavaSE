package Java.Math.DataStructures;
//��ת����
public class RotateMatrix {
	public static int N = 5;
	int [][] result = new int[N][N];
	public static void main(String[] args) {
		RotateMatrix rm = new RotateMatrix();
		rm.generateRotate(1, 0, N);
		rm.printResult();
	}
	
	//������ת����
	public void generateRotate(int number, int begin, int size){
		if(size == 1){
			result[begin][begin] = number;
			return;
		}
		
		if(size == 0){
			return;
		}
		//��������A
		int i = begin;
		int j = begin;
		for(int k = 0; k < size - 1; k++){
			result[i][j] = number;
			number++;
			i++;
		}
		
		//��������B
		for(int k = 0; k < size - 1; k++){
			result[i][j] = number;
			number++;
			j++;
		}
		
		//��������C
		for(int k = 0; k < size - 1; k++){
			result[i][j] = number;
			number++;
			i--;
		}
		
		//��������D
		for(int k = 0; k < size - 1; k++){
			result[i][j] = number;
			number++;
			j--;
		}
		
		//�ݹ����
		generateRotate(number, begin + 1, size - 2);
	}
	
	//��ӡ���
	public void printResult(){
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				System.out.print(result[i][j] + "	");
				if(j == N - 1){
					System.out.println();
				}
			}
		}
	}
}

