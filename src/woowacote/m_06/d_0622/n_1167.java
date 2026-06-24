package woowacote.m_06.d_0622;

/*
N(노드 개수) A(그래프 데이터 저장 인접 리스트)
visited(방문 기록 저장 배열) distance(거리 저장 배열)
for(N의 개수만큼 반복) {
    A 인접 리스트의 각 ArrayList초기화
}
for(N의 개수만큼 반복하기){
    A인접 리스트에 그래프 데이터 저장
}
visited 배열 초기화
distance 배열 초기화
BFS(임의의 점을 시작점으로) 실행
distance 배열에서 가장 큰 값 지닌 노드로 다시 시작
visited배열 초기화
distance배열 초기화
BFS(새로운 시작점으로) 실행
distance 배열에서 가장 큰 값으로 실행해주기
BFS{
    큐 자료구조에 시작 노드 삽입(add연산)
    visited배열에 현재 노드 방문 기록
    while(큐가 비기전까지){
        큐에서 노드 데이터 poll
        현재 노드의 연결 노드 중 방문안한 노드로
        큐에 데이터 삽입(add 연산)하고 visited 배열에 방문 기록
        그리고 현재 노드의 거리 + 에지의 가중치로 방문하지 않은 노드 거리 배열 업데이트
    }
}

Edge 클래스 생성{
    e(목적지), value(에지의 가중치)
}
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n_1167 {

    private static ArrayList<Edge>[] arr;
    private static boolean[] visited;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            while (true) {
                int E = Integer.parseInt(st.nextToken());
                if (E == -1) {
                    break;
                }
                int V = Integer.parseInt(st.nextToken());
                arr[S].add(new Edge(E, V));
            }
        }
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        bfs(1);
        int Max = 1;
        for (int i = 2; i <= N; i++) {
            if (distance[Max] < distance[i]) {
                Max = i;
            }
        }

        distance = new int[N + 1];
        visited = new boolean[N + 1];
        bfs(Max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    private static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;
        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for (Edge i : arr[now_node]) {
                int e = i.e;
                int v = i.value;
                if (!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now_node] + v;
                }
            }
        }
    }

    private static class Edge {
        int e;
        int value;

        public Edge(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }

}
