package Java.Math.DataStructures;

public class Pnr {
	public static void main(String[] args) {

	}

	public boolean prime() {
		int j = 0;
		for (int i = 0; i <= 100; i++) {
			int k = (int) Math.sqrt(i * 1.0);
			for (j = 2; j <= k; j++)
				if (i % j == 0)
					break;
			if (j >= k + 1)
				return true;
		}
		return false;
	}
}
