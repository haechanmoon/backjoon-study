package woowacote.m_07.d_0714;

/*
이분 그래프 판별하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class n_1707 {

    private static int testCase, edge, node;
    private static ArrayList<Integer>[] arr;
    private static int[] nodes;
    private static boolean[] visited;
    private static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        testCase = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            node = Integer.parseInt(st.nextToken());
            edge = Integer.parseInt(st.nextToken());
            arr = new ArrayList[edge + 1];
            for (int j = 0; j < edge; j++) {
                arr[j] = new ArrayList<>();
            }
            visited = new boolean[node + 1];
            nodes = new int[node + 1];
            isEven = true;
            sb =
            for (int j = 0; j < edge; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                arr[u].add(v);
                arr[v].add(u);
            }
            for (int j = 0; j < node; j++) {
                if (isEven) {
                    dfs(j);
                } else {
                    break;
                }
                if (isEven) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (int i : arr[node]) {
            if (!visited[i]) {
                nodes[i] = (nodes[node] + 1) % 2;
                dfs(i);
            } else if (nodes[node] == nodes[i]) {
                isEven = false;
            }

        }
    }
}
