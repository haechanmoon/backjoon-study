package Solved_ac.class3;

/*
야! 이거 점화식! 기억남?
1. dp[i]를 한글로 정의하라 (가장 중요)!
2. 이웃한 dp[i-1] dp[i-2]를 어떻게 이용할 것인지 생각해라.
3. 초기값을 정해라.

한번 해볼까?
1. dp[i] 는 1,2,3 을 이용하여 나타낼 수 있는 연산의 수 (순서 중요함)
2. dp[i] = dp[i-1]*2 근데 이게 만만치 않은게. if i % 2 ==0 일때 예를들어 2+2 는 자리 바꿔도 똑같은데
이거는 따로 설정해둬야할듯!
아 이게아녔어!
dp[i] = dp[i-1]+dp[i-2]+dp[i-3] 이거야!
이거를 for 문으로 N번가면되는거지.
DP재밌는데?
 */

import java.io.*;

public class n_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 12; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb);
    }
}
