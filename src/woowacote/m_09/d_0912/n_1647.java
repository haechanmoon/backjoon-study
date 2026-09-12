package woowacote.m_09.d_0912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n_1647 {

    private static int[] parent;
    private static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int houseCount = Integer.parseInt(st.nextToken());
        int roadCount = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[roadCount];
        for (int i = 0; i < roadCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, cost);
        }
        Arrays.sort(edges);

        parent = new int[houseCount + 1];
        size = new int[houseCount + 1];
        for (int house = 1; house <= houseCount; house++) {
            parent[house] = house;
            size[house] = 1;
        }

        int totalCost = 0;
        int usedEdgeCount = 0;
        for (Edge edge : edges) {
            if (usedEdgeCount == houseCount - 2) {
                break;
            }
            if (union(edge.start, edge.end)) {
                totalCost += edge.cost;
                usedEdgeCount++;
            }
        }

        System.out.println(totalCost);
    }

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return false;
        }

        if (size[rootA] < size[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }
        parent[rootB] = rootA;
        size[rootA] += size[rootB];
        return true;
    }

    private static int find(int house) {
        if (parent[house] == house) {
            return house;
        }
        return parent[house] = find(parent[house]);
    }

    private static class Edge implements Comparable<Edge> {

        private final int start;
        private final int end;
        private final int cost;

        private Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(cost, other.cost);
        }
    }
}
