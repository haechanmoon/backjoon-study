package woowacote.d_0618;

//dfs는 재귀로? 아니면 스택으로 해도될 것 같긴한데. 재귀로 가자.
//bfs는 큐로 고고.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n_1260 {


    private static int N, M, V;
    private static boolean[] visited;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N];
        dfs(V);
        System.out.println();

        visited = new boolean[N];
        bfs(V);
        System.out.println();
    }

    private static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (Integer value : graph[start]) {
            if (!visited[value]) {
                dfs(value);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.println(now + " ");
            for (int i : graph[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
