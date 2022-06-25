package Java.Math.DataStructures;

public class SeqSearch {
	public static void main(String[] args) {

	}

	public int SeqSearch(int r[], int n, int k) {
		int i = n;
		r[0] = k;
		while (r[i] != k)
			i--;
		return i;
	}
}
