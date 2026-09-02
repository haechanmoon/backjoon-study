package woowacote.m_09.d_0902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class n_1197 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, weight));
        }

        parent = new int[vertexCount + 1];
        for (int vertex = 1; vertex <= vertexCount; vertex++) {
            parent[vertex] = vertex;
        }

        int usedEdgeCount = 0;
        int totalWeight = 0;

        while (usedEdgeCount < vertexCount - 1) {
            Edge edge = edges.poll();

            if (union(edge.start, edge.end)) {
                totalWeight += edge.weight;
                usedEdgeCount++;
            }
        }

        System.out.println(totalWeight);
    }

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return false;
        }

        parent[rootB] = rootA;
        return true;
    }

    private static int find(int vertex) {
        if (vertex == parent[vertex]) {
            return vertex;
        }

        return parent[vertex] = find(parent[vertex]);
    }

    private static class Edge implements Comparable<Edge> {

        private final int start;
        private final int end;
        private final int weight;

        private Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
}
