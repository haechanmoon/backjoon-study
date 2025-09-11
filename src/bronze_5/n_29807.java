package bronze_5;

import java.util.Scanner;

public class n_29807 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int kor = sc.nextInt();
		int math = sc.nextInt();
		int eng = sc.nextInt();
		int tam = sc.nextInt();
		int sec = sc.nextInt();
		int num1, num2, num3;
		int hak;
		if (kor > eng) {
			num1 = (kor - eng) * 508;
		} else {
			num1 = (eng - kor) * 108;
		}

		if (math > tam) {
			num2 = (math - tam) * 212;
		} else {
			num2 = (tam - math) * 305;
		}

		if (sec > 0) {
			num3 = sec * 707;
		} else {
			num3 = 0;
		}
		hak = (num1+num2+num3)*4763;
		
		System.out.println(hak);
	}

}
