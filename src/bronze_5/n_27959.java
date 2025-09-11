package bronze_5;

import java.util.Scanner;
public class n_27959 {

	public static void main(String[] args) {
		int n,m;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		int a = 100 * n;
		if (a>=m)
			System.out.println("Yes");
		else
			System.out.println("No");
		
		
	}

}
