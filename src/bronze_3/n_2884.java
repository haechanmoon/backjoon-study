package bronze_3;

import java.util.Scanner;

public class n_2884 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		// 0시 45분 미만일때 23시로 변환
		// 분단위가 45분 미만일때 h 다운,m에 15를 더해준다~
		// 분단위가 45분 이상일때 m만 다운
		// 위의 것 처럼 하지 말고 그냥 분에 있는 45를 확 빼버리고 경우 나눠.
		int new_h = h;
		int new_m = m - 45;

		if (new_m < 0) {
			new_h--;
			new_m += 60;
		}
		if (new_h < 0) {
			new_h = 23;
		}
		System.out.println(new_h + " " + new_m);
	}
} 
