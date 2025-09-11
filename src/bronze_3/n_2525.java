package bronze_3;

import java.util.Scanner;

public class n_2525 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int a = m+n;
		
		if (a>60) {
			h++;	
			a -= 60;
			if( h>24)
				h -= 24;
			}
		System.out.print(h +" "+ a);
	}

}
