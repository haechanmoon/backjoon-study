package woowacote.m_10.d_1026;

/*
정수를 1로 만들기
 */

import java.util.Scanner;

public class n_1463 {

    public static int result;
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        result = 0;
        int[] dp = new int[1_000_001];
        for (int i = 1; i <= N; i++) {
            dp[i] = -1;
        }
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= N; i++) {
            if (i % 6 == 0) {
                dp[i] = Math.min(dp[i - 1], Math.min(dp[i / 2], dp[i / 3])) + 1;
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i - 1], dp[i / 2]) + 1;
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i - 1], dp[i / 3]) + 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        System.out.print(dp[N]);
    }
}

/*
개선 버전: 필요한 크기만 할당하고, 1을 빼는 경우를 기준으로 최솟값을 갱신한다.
dp[i] = i를 1로 만드는 최소 연산 횟수
int 배열의 기본값은 0이므로 dp[1]은 별도 초기화가 필요 없다.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            // 1을 빼는 연산은 모든 i에서 가능하다.
            dp[i] = dp[i - 1] + 1;

            // 두 조건을 각각 검사해서 6의 배수도 두 경로를 모두 비교한다.
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.print(dp[n]);
    }
}
*/
