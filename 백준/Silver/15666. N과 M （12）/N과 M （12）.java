/*
이거 보니까. 뭔지 알겠다. 어떻게 하는지 알겠다.
for문안에 dfs들어가있는거 좀 복잡하긴 한데. 이거 그냥 어쩔 수 없음. 뚫어야해.
그림그려가면서 풀면 무조건 할 수 있음. 천천히 하면 할 수 있다고 생각을 한다. 
재귀함수가 어렵긴하네. 피보나치 수열은 진짜 기본중에 기본이구만. 물론 그것도 어렵긴한데.
이게 코드를 보면서 이해하는것도 애초에 쉽지않음. 많은 훈련이 필요한 듯.
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] result;
    private static int[] basket;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        basket = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            basket[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(basket);

        dfs(0, 0);
        System.out.print(sb);
    }

    public static void dfs(int start, int depth) {
        if (depth == M) {
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = start; i < N; i++) {
            if (before != basket[i]) {
                result[depth] = basket[i];
                before = basket[i];
                dfs(i, depth + 1);
            }
        }
    }
}