package woowacote.m_08.d_0820;

/*
타임머신으로 빨리 가기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_11657 {

    public static int N, M, K;
    public static Edge11657[] edges;
    public static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge11657[M + 1];
        distance = new int[N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge11657(start, end, time);
        }
        for (int i = 2; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[1] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= M; j++) {
                Edge11657 edge = edges[j];
                if (distance[edge.start] != Integer.MAX_VALUE
                    && distance[edge.end] > distance[edge.start] + edge.time) {
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }
        boolean mCycle = false;

        for (int i = 1; i <= M; i++) {
            Edge11657 edge = edges[i];
            if (distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time) {
                mCycle = true;
            }
        }
        if (!mCycle) {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        } else {
            System.out.println("-1");
        }
    }
}

class Edge11657 {
    int start, end, time;

    Edge11657(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}
