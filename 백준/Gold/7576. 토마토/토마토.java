import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int width, length;
    static int[][] box;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        width = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());

        box = new int[length][width];
        int yetCount = 0;

        for (int i = 0; i < length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < width; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
                else if (box[i][j] == 0) {
                    yetCount++;
                }
            }
        }

        if (yetCount == 0) {
            System.out.println(0);
            return;
        }

        int days = bfs();

        System.out.println(checkDays(days));
    }

    public static int bfs() {
        int days = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int y = current[0];
                int x = current[1];

                for (int d = 0; d < 4; d++) {
                    int nextY = y + dy[d];
                    int nextX = x + dx[d];
                    if (nextY >= 0 && nextY < length && nextX >= 0 && nextX < width && box[nextY][nextX] == 0) {
                        box[nextY][nextX] = 1;
                        queue.add(new int[]{nextY, nextX});                    }
                }
            }

            if (!queue.isEmpty()) {
                days++;
            }
        }
        return days;
    }
    public static int checkDays(int days) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (box[i][j] == 0) {
                    return -1;
                }
            }
        }
        return days;
    }
}