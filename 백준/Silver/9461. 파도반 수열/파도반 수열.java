/*
이건 딱 보아하니 DP를 쓰는 문제다.
1. dp[i] = 한 변의 길이.
2. dp[i] = dp[i-3] + dp[i-2]
3. dp[1] = 1 dp[2] = 1 dp[3] = 1 dp[4] = 2
아! 이 문제는 그림을 보아하니 dp[i] = dp[i-1]-dp[i-5]가 맞다!
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for(int i = 6; i <= 100; i++){
            dp[i] = dp[i-1] + dp[i-5];
        }
        StringBuilder sb = new StringBuilder();
       for(int i = 0 ; i<N;i++) {
           int num = Integer.parseInt(br.readLine());
           sb.append(dp[num]).append("\n");
       }
        System.out.println(sb);
    }
}
