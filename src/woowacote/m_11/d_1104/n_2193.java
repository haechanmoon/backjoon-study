package woowacote.m_11.d_1104;

/*
이친수구하기
근데 이거 구하다 보니까 갑자기 피보나치가 되어버렸는데
이거 왜 이렇게 됐는지 잘 모르겠음...
 */

import java.util.Scanner;

public class n_2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] dp = new long[91];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        System.out.print(dp[N]);
    }
}
