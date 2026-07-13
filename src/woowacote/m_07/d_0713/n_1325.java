package woowacote.m_07.d_0713;

/*
효율적으로 해킹하기.
이 문제는 BFS의 정석이자. 그래프를 이해하는데 아주 좋은 문제인 것 같다. 자. 풀어보자.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n_1325 {

    private static int computerCount, edge;
    private static ArrayList<Integer>[] arr;
    private static int[] computers;
    private static int max;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        computerCount = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        arr = new ArrayList[computerCount + 1];
        for (int i = 1; i <= computerCount; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
        }
        computers = new int[computerCount + 1];

        for (int i = 1; i <= computerCount; i++) {
            bfs(i);
        }

        max = 0;
        for (int val : computers) {
            if (val > max) {
                max = val;
            }
        }
        for (int i = 1; i < computerCount; i++) {
            if (computers[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void bfs(int node) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[computerCount + 1];
        que.add(node);
        visited[node] = true;
        while (!que.isEmpty()) {
            int current = que.poll();
            for (int v : arr[current]) {
                if (!visited[v]) {
                    visited[v] = true;
                    computers[v]++;
                    que.add(v);
                }
            }
        }
    }
}
