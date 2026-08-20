package woowacote.m_08.d_0818;

/*
최소 비용 구하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class n_1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityCount = Integer.parseInt(br.readLine());
        int busCount = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[cityCount + 1];
        for (int i = 1; i <= cityCount; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= busCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start].add(new Edge(end, weight));
        }

    }
}

class Edge {
    public int bridge;
    public int weight;

    Edge(int a, int b) {
        this.bridge = a;
        this.weight = b;
    }
}
