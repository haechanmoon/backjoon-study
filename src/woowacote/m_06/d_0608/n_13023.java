package woowacote.m_06.d_0608;

/*
sudo코드 작성

일단. 젤 위에 static에 인접리스트 선언
방문 배열 선언
count  0 선언

N,M 받기
인접리스트 graph NEW생성
graph초기화 N개만큼 초기화
방문배열 생성

간선 그래프 연결
dfs(0) 시작~
count 개수 반환~

dfs( int node)
만약 방문배열이 false라면?
count++ 하고
dfs한번 더 돌아~


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class n_13023 {

    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static boolean found;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 0);
            if (found) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static void dfs(int node, int depth) {
        if (depth == 4) {
            found = true;
            return;
        }

        visited[node] = true;

        for (int nextNode : graph[node]) {
            if (!visited[nextNode]) {
                dfs(nextNode, depth + 1);
                if (found) {
                    return;
                }
            }
        }

        visited[node] = false;
    }
}
