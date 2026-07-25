package woowacote.m_07.d_0721;

/*
이분 그래프 판별하기 해봅시다~
일단 각 노드가 tf로 나눠져있습니다. ~! 근데 이거 true,false로 구현하면 되겠죠? ~! 해봅시다.

테스트 케이스 입력받음
테스트 케이스만큼 for문을 돈다.
노드와 간선개수를 받는다.
노드 만큼 int[]만든다.
visite 만든다.
인접리스트를 활용하여 그래프를 그린다. (인접리스트 초기화 과정 잊지 않기.)
boolean flag를 두어 true와 false를 활용해본다.
모든 노드에 dfs를 돈다.
일단 처음에 간 노드에 false를두고 방문을 확인한다.
visited도 표시해준다.
그 다음에 별 문제가 없이 dfs가 끝났다면 YES를 StringBuilder에 표시해둔다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class n_1707 {

    static int node, edge;
    static boolean[] visited, colors;
    static boolean flag;
    static int[] nodes;
    static ArrayList<Integer>[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int k = 0; k < testCase; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            node = Integer.parseInt(st.nextToken());
            edge = Integer.parseInt(st.nextToken());

            visited = new boolean[node + 1];
            nodes = new int[node + 1];
            colors = new boolean[node + 1];
            arr = new ArrayList[node + 1];
            for (int i = 1; i <= node; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i < node; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[u].add(v);
                arr[v].add(u);
            }
            for (int i = 1; i <= node; i++) {
                dfs(i);
            }
        }
        System.out.println(sb);
    }

    private static void dfs(int value) {
        if (!visited[value]) {
            for (int i = 1; i <= node; i++) {
                visited[value] = true;


            }
        }
    }
}
