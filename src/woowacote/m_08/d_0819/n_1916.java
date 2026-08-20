package woowacote.m_08.d_0819;

/*
 최소비용 구하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class n_1916 {

    private static ArrayList<Edge0819>[] graph;
    private static boolean[] visited;
    private static int[] distance;
    private static PriorityQueue<Edge0819> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge0819(v, w));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        pq = new PriorityQueue<>();

        pq.offer(new Edge0819(start, 0));
        distance[start] = 0;
        while (!pq.isEmpty()) {
            Edge0819 current = pq.poll();
            int now = current.a;
            if (!visited[now]) {
                visited[now] = true;
                for (Edge0819 v : graph[now]) {
                    if (!visited[v.a] && distance[v.a] > distance[now] + v.b) {
                        distance[v.a] = distance[now] + v.b;
                        pq.add(new Edge0819(v.a, distance[v.a]));
                    }
                }
            }
        }
        System.out.println(end);
    }
}

class Edge0819 implements Comparable<Edge0819> {

    public final int a;
    public final int b;


    Edge0819(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Edge0819 o) {
        return b - o.b;
    }
}
