package woowacote.m_09.d_0901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n_1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int INF = N + 1;
        int[][] distance = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            distance[a][b] = 1;
            distance[b][a] = 1;
        }
        for (int via = 1; via <= N; via++) {
            for (int from = 1; from <= N; from++) {
                for (int to = 1; to <= N; to++) {
                    if (distance[from][via] != Integer.MAX_VALUE && distance[via][to] != Integer.MAX_VALUE) {
                        distance[from][to] = Math.min(distance[from][to], distance[from][via] + distance[via][to]);
                    }
                }
            }
        }

        int answer = 1;
        int minKevinBacon = Integer.MAX_VALUE;

        for (int person = 1; person <= N; person++) {
            int sum = 0;

            for (int other = 1; other <= N; other++) {
                sum += distance[person][other];
            }
            if (sum < minKevinBacon) {
                minKevinBacon = sum;
                answer = person;
            }
        }
        System.out.println(answer);
    }
}
