package Solved_ac.class2;

import java.util.Scanner;

public class n_2609_advanced {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        int a = N; // 원본 N을 복사
        int b = M; // 원본 M을 복사

        while (b != 0) {
            int r = a % b; // 나머지(remainder)를 구한다

            // a와 b의 값을 한 칸씩 옆으로 이동시킨다
            a = b;
            b = r;
        }
// while문이 끝나면 a에 최대공약수가 남게 된다.
        System.out.println(a);

        // 위에서 a에 최대공약수를 구해놨다고 가정
        int lcm = (N * M) / a;
        System.out.println(lcm);
    }
}
