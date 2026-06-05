package woowacote.d_0605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class n_2606 {
    static int n;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr.get(u).add(v);
            arr.get(v).add(u);
        }

        dfs(1);

        int result = 0;
        for (boolean visit : visited) {
            if (visit) {
                result++;
            }
        }
        System.out.println(result - 1);
    }

    private static void dfs(int node) {
        visited[node] = true;

        for (int nextNode : arr.get(node)) {
            if (!visited[nextNode]) {
                dfs(nextNode);
            }
        }
    }
}
