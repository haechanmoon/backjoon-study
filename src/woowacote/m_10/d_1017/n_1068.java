package woowacote.m_10.d_1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class n_1068 {

    public static ArrayList<Integer>[] graph;
    public static int[] parent;
    public static int N;
    public static int deleteNode;
    public static boolean[] visited;
    public static int leafCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
        }
        deleteNode = Integer.parseInt(br.readLine());

        //parent 에서 지울노드 고르고 그 아래에 딸린 것들은 다 -1로 처리한다.

        //그걸 바탕으로 그래프를 그린다.(-1은 넣지 않음)

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        int root = -1;
        for (int i = 0; i < N; i++) {
            if (parent[i] == -1) {
                root = i;
            }
        }
        if (root == deleteNode) {
            System.out.print(0);
            return;
        }
        delete(deleteNode);
        for (int i = 0; i < N; i++) {
            if (parent[i] == -1) {
                continue;
            }
            int v = parent[i];
            graph[i].add(v);
            graph[v].add(i);
        }
        visited = new boolean[N];

        leafCount = 0;
        dfs(root);

        // leaf를 찾고 ++;
        System.out.print(leafCount);
    }

    private static void delete(int deleteNode) {
        parent[deleteNode] = -1;
        for (int i = 0; i < N; i++) {
            if (parent[i] == deleteNode) {
                parent[i] = -1;
                delete(i);
            }
        }
    }

    public static void dfs(int start) {
        visited[start] = true;
        boolean hasChild = false;
        for (int value : graph[start]) {
            if (!visited[value]) {
                hasChild = true;
                visited[value] = true;
                dfs(value);
            }
        }
        if (!hasChild) {
            leafCount++;
        }
    }
}
