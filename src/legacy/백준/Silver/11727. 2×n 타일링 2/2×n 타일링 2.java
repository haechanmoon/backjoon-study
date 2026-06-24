/*
이건 내가 생각을 해봤는데 일단 DP가 맞고
dp[i] = dp[i-2]*2 + dp[i-1] 이게 맞나?
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[1] = 1;
        if (n >= 2) {
            dp[2] = 3;
        }
        for (int i = 3;i<n+1;i++){
            dp[i] = (dp[i-2]*2 + dp[i-1])%10007;
        }
        System.out.print(dp[n]);
    }
}