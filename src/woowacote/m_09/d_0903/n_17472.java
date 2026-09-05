package woowacote.m_09.d_0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class n_17472 {

    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    private static int rowCount;
    private static int columnCount;
    private static int[][] board;
    private static boolean[][] visited;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowCount = Integer.parseInt(st.nextToken());
        columnCount = Integer.parseInt(st.nextToken());

        board = new int[rowCount][columnCount];
        visited = new boolean[rowCount][columnCount];

        for (int row = 0; row < rowCount; row++) {
            st = new StringTokenizer(br.readLine());
            for (int column = 0; column < columnCount; column++) {
                board[row][column] = Integer.parseInt(st.nextToken());
            }
        }

        int islandCount = labelIslands();
        PriorityQueue<Edge> bridges = findBridges();
        int answer = connectIslands(islandCount, bridges);

        System.out.println(answer);
    }

    private static int labelIslands() {
        int islandNumber = 0;

        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                if (board[row][column] == 1 && !visited[row][column]) {
                    markIsland(row, column, ++islandNumber);
                }
            }
        }

        return islandNumber;
    }

    private static void markIsland(int startRow, int startColumn, int islandNumber) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startRow, startColumn});
        visited[startRow][startColumn] = true;
        board[startRow][startColumn] = islandNumber;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int column = current[1];

            for (int direction = 0; direction < 4; direction++) {
                int nextRow = row + DR[direction];
                int nextColumn = column + DC[direction];

                if (!isInBounds(nextRow, nextColumn)) {
                    continue;
                }
                if (board[nextRow][nextColumn] == 0 || visited[nextRow][nextColumn]) {
                    continue;
                }

                visited[nextRow][nextColumn] = true;
                board[nextRow][nextColumn] = islandNumber;
                queue.add(new int[]{nextRow, nextColumn});
            }
        }
    }

    private static PriorityQueue<Edge> findBridges() {
        PriorityQueue<Edge> bridges = new PriorityQueue<>();

        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                if (board[row][column] == 0) {
                    continue;
                }

                for (int direction = 0; direction < 4; direction++) {
                    addBridge(row, column, direction, bridges);
                }
            }
        }

        return bridges;
    }

    private static void addBridge(int row, int column, int direction, PriorityQueue<Edge> bridges) {
        int startIsland = board[row][column];
        int nextRow = row + DR[direction];
        int nextColumn = column + DC[direction];
        int length = 0;

        while (isInBounds(nextRow, nextColumn) && board[nextRow][nextColumn] == 0) {
            length++;
            nextRow += DR[direction];
            nextColumn += DC[direction];
        }

        if (!isInBounds(nextRow, nextColumn)) {
            return;
        }

        int endIsland = board[nextRow][nextColumn];
        if (startIsland != endIsland && length >= 2) {
            bridges.add(new Edge(startIsland, endIsland, length));
        }
    }

    private static int connectIslands(int islandCount, PriorityQueue<Edge> bridges) {
        parent = new int[islandCount + 1];
        for (int island = 1; island <= islandCount; island++) {
            parent[island] = island;
        }

        int connectedBridgeCount = 0;
        int totalLength = 0;

        while (!bridges.isEmpty() && connectedBridgeCount < islandCount - 1) {
            Edge bridge = bridges.poll();

            if (union(bridge.start, bridge.end)) {
                totalLength += bridge.length;
                connectedBridgeCount++;
            }
        }

        if (connectedBridgeCount != islandCount - 1) {
            return -1;
        }
        return totalLength;
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

    private static int find(int island) {
        if (island == parent[island]) {
            return island;
        }

        return parent[island] = find(parent[island]);
    }

    private static boolean isInBounds(int row, int column) {
        return row >= 0 && row < rowCount && column >= 0 && column < columnCount;
    }

    private static class Edge implements Comparable<Edge> {

        private final int start;
        private final int end;
        private final int length;

        private Edge(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.length, other.length);
        }
    }
}
