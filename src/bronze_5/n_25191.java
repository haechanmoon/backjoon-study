package bronze_5;

import java.util.Scanner;

public class n_25191 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n, a, b;
		n = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();
		int c = a / 2 + b;

		if (n >= c) {
			System.out.println(c);
		} else {
			System.out.println(n);
		}

	}
}
