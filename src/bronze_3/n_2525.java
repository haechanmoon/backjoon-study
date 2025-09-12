package bronze_3;

import java.util.Scanner;

public class n_2525 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();

        int total = h*60+m+n;
        int h = total/60&24;
        int m = total%60;

        System.out.printf(h+" "+m);
    }
}
