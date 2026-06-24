import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        int startY = -1, startX = -1;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'I') {
                    startY = i;
                    startX = j;
                }
            }
        }

        int friendCount = bfs(startY, startX);

        if (friendCount == 0) {
            System.out.println("TT");
        } else {
            System.out.println(friendCount);
        }
    }

    public static int bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX});
        visited[startY][startX] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) {
                    if (!visited[nextY][nextX] && map[nextY][nextX] != 'X') {
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});

                        if (map[nextY][nextX] == 'P') {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}