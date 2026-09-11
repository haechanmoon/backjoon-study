package woowacote.m_09.d_0910;

/*
다리 만들기

이거 배울거 진짜 많다.
1. bfs로 섬을 확정시켜놔야해.
2. 1번섬부터 모든 섬으로 찔러봐야해. 다리를 놔보는 거야.
3. 거기서 이제 union/find를 하면서 최소 신장 트리를 만드는거야.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class n_17472 {

    private static int N, M;
    private static boolean[][] visited;
    private static int[] parent;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int[][] board;
    private static PriorityQueue<Edge0910> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int current = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, current);
                    current++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                int from = board[i][j];
                for (int direction = 0; direction < 4; direction++) {
                    int nextX = i + dx[direction];
                    int nextY = j + dy[direction];
                    int length = 0;

                    while (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                        if (board[nextX][nextY] == 0) {
                            length++;
                            nextX += dx[direction];
                            nextY += dy[direction];
                            continue;
                        }
                        if (board[nextX][nextY] != from && length >= 2) {
                            int to = board[nextX][nextY];
                            pq.offer(new Edge0910(from, to, length));
                        }
                        break;
                    }
                }
            }
        }

        int islandCount = current - 1;
        parent = new int[islandCount + 1];
        for (int i = 1; i <= islandCount; i++) {
            parent[i] = i;
        }

        int totalLength = 0;
        int bridgeCount = 0;
        while (!pq.isEmpty() && bridgeCount < islandCount - 1) {
            Edge0910 edge = pq.poll();
            if (union(edge.start, edge.end)) {
                totalLength += edge.weight;
                bridgeCount++;
            }
        }

        System.out.println(bridgeCount == islandCount - 1 ? totalLength : -1);
    }

    private static int find(int island) {
        if (parent[island] == island) {
            return island;
        }
        return parent[island] = find(parent[island]);
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

    private static void bfs(int x, int y, int currentLand) {
        Queue<int[]> queue = new LinkedList<>();

        visited[x][y] = true;
        board[x][y] = currentLand;
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] ace = queue.poll();
            int currentX = ace[0];
            int currentY = ace[1];
            for (int distance = 0; distance < 4; distance++) {

                int nextX = dx[distance] + currentX;
                int nextY = dy[distance] + currentY;
                if ((nextX) >= 0 && (nextY) >= 0 && (nextX) < N && (nextY) < M && board[nextX][nextY] >= 1
                    && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    board[nextX][nextY] = currentLand;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    private static class Edge0910 implements Comparable<Edge0910> {
        private final int start;
        private final int end;
        private final int weight;

        private Edge0910(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge0910 o) {
            return weight - o.weight;
        }
    }
}
