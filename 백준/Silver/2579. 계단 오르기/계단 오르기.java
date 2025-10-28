/*
이건 아주 쉽게 풀 수 있을 것 같긴함. 규칙을 찾았어. 근데 이게 맞을 지는 잘 모르겠다.
자. 일단. 마지막에서부터 시작해도 될 것 같은 느낌인게, 마지막꺼는 무조건 밟아야하기 때문에이야.
그래서 뒤에서 부터 시작하는거지.
뒤에서부터 전꺼랑 전전꺼 중에 큰거 고름. 거기서부터 시작.
그럼 이거를 어떻게 풀어야할까.
배열을 이용해서? 반복문? 그렇게 하면 될 것 같은데...근데 이제 마지막이 문제야.
마지막은 만얀에 세번째는 상관없는데 두번째꺼 밟았으면. 아. 첫번째를 0이라 두면 되겠네.
오키오키
해보자.
아. 와 점화식이었네. 어쩐지. 근데 느낌 오긴 했었음. 충분히 구현할 수 있을듯?
1. DP정의 dp[i] = i번째 까지 올라왔을 때. Max
2. dp[i] = max(dp[i-3]+score[i-1]+score[i], dp[i-2]+score[i])
3. dp[1] = 1번째 dp[2] = 2번째, dp[3] = 3번째 계단.
 */

import static java.lang.Math.max;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N + 1];
        for (int i = 1; i < N+1; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N + 1];

        dp[1] = score[1];
        if (N >= 2) {
            dp[2] = score[1] + score[2];
        }
        for (int i = 3; i < N+1; i++) {
            dp[i] = max(dp[i - 3] + score[i-1] + score[i], dp[i-2] + score[i]);
        }

        System.out.print(dp[N]);
    }
}
