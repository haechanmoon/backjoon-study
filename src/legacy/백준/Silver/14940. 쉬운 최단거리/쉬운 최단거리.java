import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m];
        int startY = -1, startX = -1;


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dist[i], -1);
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    startY = i;
                    startX = j;
                } else if (map[i][j] == 0) {
                    dist[i][j] = 0;
                }
            }
        }

        bfs(startY, startX);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    // BFS
    public static void bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();

        dist[startY][startX] = 0;
        queue.add(new int[]{startY, startX});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currY = current[0];
            int currX = current[1];

            for (int i = 0; i < 4; i++) {
                int nextY = currY + dy[i];
                int nextX = currX + dx[i];

                if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m) {
                    if (map[nextY][nextX] == 1 && dist[nextY][nextX] == -1) {
                        dist[nextY][nextX] = dist[currY][currX] + 1;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}