/*
하 이거 쉬운듯하면서도 어렵네. 어떡하지. 자 일단. 음...
DFS BFS함수 만들어야지. 노드수, 간선개수, 시작점을 매개변수로 갖는거야.
DFS는 스택을 사용하고 BFS는 큐를 사용하는거야.
할 수 있겠지?
아 방문코드 안짜서 한번 나락갔었네.
dfs,bfs가 쉬운듯하면서도 아직 어렵단말이지...
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(V);

        sb.append("\n");

        Arrays.fill(visited, false);

        bfs(V);

        System.out.println(sb);
    }

    public static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        sb.append(startNode).append(" ");
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : graph.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    sb.append(neighbor).append(" ");
                }
            }
        }
    }
}
