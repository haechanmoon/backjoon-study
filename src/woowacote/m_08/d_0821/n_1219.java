package woowacote.m_08.d_0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class n_1219 {
    private static final long UNREACHABLE = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cityCount = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int busCount = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        List<Integer>[] nextCities = new ArrayList[cityCount];
        for (int i = 0; i < cityCount; i++) nextCities[i] = new ArrayList<>();
        for (int i = 0; i < busCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            edges.add(new Edge(from, to, cost));
            nextCities[from].add(to);
        }

        long[] earnings = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] profit = new long[cityCount];
        Arrays.fill(profit, UNREACHABLE);
        profit[start] = earnings[start];

        boolean[] infinite = new boolean[cityCount];
        for (int i = 0; i < cityCount; i++) {
            for (Edge edge : edges) {
                if (profit[edge.from] == UNREACHABLE) continue;
                long nextProfit = profit[edge.from] - edge.cost + earnings[edge.to];
                if (profit[edge.to] < nextProfit) {
                    profit[edge.to] = nextProfit;
                    if (i == cityCount - 1) infinite[edge.to] = true;
                }
            }
        }

        for (int city = 0; city < cityCount; city++) {
            if (infinite[city] && canReachEnd(city, end, nextCities)) {
                System.out.println("Gee");
                return;
            }
        }
        System.out.println(profit[end] == UNREACHABLE ? "gg" : profit[end]);
    }

    private static boolean canReachEnd(int start, int end, List<Integer>[] nextCities) {
        boolean[] visited = new boolean[nextCities.length];
        int[] queue = new int[nextCities.length];
        int head = 0, tail = 0;
        queue[tail++] = start;
        visited[start] = true;
        while (head < tail) {
            int current = queue[head++];
            if (current == end) return true;
            for (int next : nextCities[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue[tail++] = next;
                }
            }
        }
        return false;
    }

    private record Edge(int from, int to, long cost) {}
}
