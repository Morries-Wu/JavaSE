package Math.DataStructures;


public class buy {
	public static void main(String[] args) {
		int x, y, z;
		for (x = 0; x <= 20; x++) {
			for (y = 0; y <= 33; y++) {
				z = 100 - x - y;
				if (5 * x + 3 * y + z / 3 == 100) {
					System.out.printf("%d %d %d \n", x, y, z);
				}
			}
		}
	}
}
