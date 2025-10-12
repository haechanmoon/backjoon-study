package Solved_ac.class3;

/*
 * 이것도 DP잖아!
 * 점화식 생각나지?
 * 1. dp[i]를 한글로 정의하라.
 * 2. dp[i] 와 이웃한 dp[i-1] dp[i-2]를 이용하라
 * 3. 초깃값을 설정하라!
 * 점화식 잘 이용하면 이거 금방 풀 수 있을듯?!
 * 필요한거!
 * BufferedReader, StringBuilder, StringTokenizer, dp[], 또 뭐가있을까...
 * 좋다! 해보자.
 * 1. dp[i] = i번째부터 끝까지 합!
 * 2. 이거는 어떻게 해야하냐면. 만약 2~4 라고 치면 2부터 N까지 더한거 구하고 거기서 dp[n-4]구하면됨!
 * 3. 근데이거 뒤에서부터 하는게 편한가? 순서는 상관없을듯. 초기값은 첫번째부터 N번째까지 다 더한거. 그거로 하자.
 * 아 이거 만약 i번째부터 j번째까지 구하라고 한건 이게 더편했던거같다. dp[j]-dp[i-1] 이게 맞았네. 왜 나는 i부터 생각했지 ㅋ
 * 근데 상관없긴한듯? ㄹㅇ ? ㅇㅈ??만약 i부터했다면 [i부터 맨뒤] - [j+1 부터 맨뒤] 이렇게 해야되네. 좀 복잡하긴하네
 * 이걸 SuffixSum 이라 하는군 ㅇㅇ
 * 그러면 이문제 쉽게 풀 수 있을듯. */

import java.io.*;
import java.util.StringTokenizer;


public class n_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[N+1];  //dp라는 이름도 좋지만 명확한 이름을 주는것이 더 좋은 방향으로 가는것!
        st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i-1] + Integer.parseInt(st.nextToken());
        }//일단 여기까지는 다 구할 수 있잖아.!

        for (int k = 0; k <M ; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int result = prefixSum[j] - prefixSum[i-1];
            sb.append(result).append("\n");
        }
        System.out.print(sb);


    }
}
