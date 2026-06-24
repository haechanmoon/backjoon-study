/*
음 어떻게 하지...이거뭔가 DP냄새나지않냐?
dp한번 해볼까?
아. 일단 1부터 50000루트까지. dp에 넣어놔야하나?이러면 dp의 의미가 좀 달라지는데.
만약 20이라쳐. 20루트쳐. 4.xx잖아. 4의 제곱 + 2의 제곱 이렇게하는거네! 그럼 두개잖아.
아 . 20이라쳐봐. 
dp[20] = 1+19 / 4+16 / 9+11 / 16+4 --> 2개. 
dp[i] = 제곱수로 나타낼 수 있는 최소 수
dp[i] = dp[i-1] +1 || dp[i-j*j] +1 중 최소
dp[1] =1
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] dp = new int[t + 1];
        dp[1] = 1;
        for (int i = 2; i <= t; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }

        }
        System.out.println(dp[t]);
    }
}
