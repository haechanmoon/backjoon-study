package bronze_5;

import java.util.Scanner;

public class n_10171 {

	public static void main(String[] args) {
		int[] a = { 1, 1, 2, 2, 2, 8 };
		Scanner sc = new Scanner(System.in);

		int[] b = new int[6];
		int[] c = new int[6];
		for (int i = 0; i < 6; i++) {
			b[i] = sc.nextInt();
			c[i] = a[i] - b[i];
		}

		for (int x = 0; x < 6; x++) {
			System.out.print(c[x]+" ");
		}
	}

}
