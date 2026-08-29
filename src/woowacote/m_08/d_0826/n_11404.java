package woowacote.m_08.d_0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n_11404 {
    private static final int INF = 100_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityCount = Integer.parseInt(br.readLine());
        int busCount = Integer.parseInt(br.readLine());
        int[][] costs = new int[cityCount + 1][cityCount + 1];
        for (int i = 1; i <= cityCount; i++) {
            Arrays.fill(costs[i], INF);
            costs[i][i] = 0;
        }

        for (int i = 0; i < busCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            costs[from][to] = Math.min(costs[from][to], cost);
        }

        for (int via = 1; via <= cityCount; via++) {
            for (int from = 1; from <= cityCount; from++) {
                for (int to = 1; to <= cityCount; to++) {
                    costs[from][to] = Math.min(costs[from][to], costs[from][via] + costs[via][to]);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int from = 1; from <= cityCount; from++) {
            for (int to = 1; to <= cityCount; to++) {
                result.append(costs[from][to] == INF ? 0 : costs[from][to]).append(' ');
            }
            result.append('\n');
        }
        System.out.print(result);
    }
}
